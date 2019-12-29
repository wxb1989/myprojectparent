断点续传的原理
其实断点续传的原理很简单，就是在 Http 的请求上和一般的下载有所不同而已。
打个比方，浏览器请求服务器上的一个文时，所发出的请求如下：
假设服务器域名为 wwww.sjtu.edu.cn，文件名为 down.zip。
GET /down.zip HTTP/1.1
Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-
excel, application/msword, application/vnd.ms-powerpoint, */*
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)
Connection: Keep-Alive

服务器收到请求后，按要求寻找请求的文件，提取文件的信息，然后返回给浏览器，返回信息如下：

200
Content-Length=106786028
Accept-Ranges=bytes
Date=Mon, 30 Apr 2001 12:56:11 GMT
ETag=W/"02ca57e173c11:95b"
Content-Type=application/octet-stream
Server=Microsoft-IIS/5.0
Last-Modified=Mon, 30 Apr 2001 12:56:11 GMT

所谓断点续传，也就是要从文件已经下载的地方开始继续下载。所以在客户端浏览器传给 Web 服务器的时候要多加一条信息 -- 从哪里开始。
下面是用自己编的一个"浏览器"来传递请求信息给 Web 服务器，要求从 2000070 字节开始。
GET /down.zip HTTP/1.0
User-Agent: NetFox
RANGE: bytes=2000070-
Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2

仔细看一下就会发现多了一行 RANGE: bytes=2000070-
这一行的意思就是告诉服务器 down.zip 这个文件从 2000070 字节开始传，前面的字节不用传了。
服务器收到这个请求以后，返回的信息如下：
206
Content-Length=106786028
Content-Range=bytes 2000070-106786027/106786028
Date=Mon, 30 Apr 2001 12:55:20 GMT
ETag=W/"02ca57e173c11:95b"
Content-Type=application/octet-stream
Server=Microsoft-IIS/5.0
Last-Modified=Mon, 30 Apr 2001 12:55:20 GMT

和前面服务器返回的信息比较一下，就会发现增加了一行：
Content-Range=bytes 2000070-106786027/106786028
返回的代码也改为 206 了，而不再是 200 了。

知道了以上原理，就可以进行断点续传的编程了。

Java 实现断点续传的关键几点
(1) 用什么方法实现提交 RANGE: bytes=2000070-。
当然用最原始的 Socket 是肯定能完成的，不过那样太费事了，其实 Java 的 net 包中提供了这种功能。代码如下：

URL url = new URL("http://www.sjtu.edu.cn/down.zip");
HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();

// 设置 User-Agent
httpConnection.setRequestProperty("User-Agent","NetFox");
// 设置断点续传的开始位置
httpConnection.setRequestProperty("RANGE","bytes=2000070");
// 获得输入流
InputStream input = httpConnection.getInputStream();
从输入流中取出的字节流就是 down.zip 文件从 2000070 开始的字节流。 大家看，其实断点续传用 Java 实现起来还是很简单的吧。 接下来要做的事就是怎么保存获得的流到文件中去了。

保存文件采用的方法。
我采用的是 IO 包中的 RandAccessFile 类。
操作相当简单，假设从 2000070 处开始保存文件，代码如下：
RandomAccess oSavedFile = new RandomAccessFile("down.zip","rw");
long nPos = 2000070;
// 定位文件指针到 nPos 位置
oSavedFile.seek(nPos);
byte[] b = new byte[1024];
int nRead;
// 从输入流中读入字节流，然后写到文件中
while((nRead=input.read(b,0,1024)) > 0)
{
oSavedFile.write(b,0,nRead);
}
怎么样，也很简单吧。 接下来要做的就是整合成一个完整的程序了。包括一系列的线程控制等等。

断点续传内核的实现
主要用了 6 个类，包括一个测试类。
SiteFileFetch.java 负责整个文件的抓取，控制内部线程 (FileSplitterFetch 类 )。
FileSplitterFetch.java 负责部分文件的抓取。
FileAccess.java 负责文件的存储。
SiteInfoBean.java 要抓取的文件的信息，如文件保存的目录，名字，抓取文件的 URL 等。
Utility.java 工具类，放一些简单的方法。
TestMethod.java 测试类。