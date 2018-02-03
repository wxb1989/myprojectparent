#输入输出流
1.1、Java 流的分类
按流向分: 输入流: 程序可以从中读取数据的流。 输出流: 程序能向其中写入数据的流。 
按数据传输单位分: 字节流: 以字节为单位传输数据的流 字符流: 以字符为单位传输数据的流 
按功能分: 节点流: 用于直接操作目标设备的流 过滤流: 是对一个已存在的流的链接和封装，通过对数据进行处理为
程序提供功能强大、灵活的读写功能。

Java 中的流分为两种，一种是字节流，另一种是字符流，
分别由四个抽象类来表示（每种流包括输入和输出两种所以一共四个）:InputStream，OutputStream，Reader，Writer
在 Java 的 IO 中，所有的 stream（包括 Inputstream 和 Out stream）
都包括两种类型： (1)字节流 表示以字节为单位从 stream 中读取或往 stream 中写入信息，即 io 包中的 inputstream 类和 outputstream 类的派生类。通常用来读取二进制数据，如图象和声音。 
（2）字符流 以 Unicode 字符为导向的 stream，表示以 Unicode 字符为单位从 stream 中读取或往 stream 中写入信息。 区别： Reader 和 Writer 要解决的，最主要的问题就是国际化。
原先的 I/O 类库只支持8位的字节流，因此不可能很好地处理16位的 Unicode 字符流。Unicode 是国际化的字符集(更何况 Java 内置的 char 就是16位的 Unicode 字符)，这样加了 Reader 和 Writer 之后，所有的 I/O 就都支持 Unicode 了。
此外新类库的性能也比旧的好。 但是，Read 和 Write 并不是取代 InputStream 和 OutputStream，有时，你还必须同时使用”基于 byte 的类”和”基于字符的类”。为此，它还提供了两个”适配器(adapter)”类。InputStreamReader 负责将 InputStream 转化成 Reader，而 OutputStreamWriter 则将 OutputStream 转化成 Writer。 




