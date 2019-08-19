#Java 虚拟机
Java 虚拟机工作原理详解

![](https://uploadimg.markbj.com/static/resource/image/book/448ebeda258f11e79e8000163e13356e.png)



从这个框图很容易大体上了解 java 程序工作原理。首先，你写好 java 代码，保存到硬盘当中。然后你在命令行中输入

从这个框图很容易大体上了解 java 程序工作原理。首先，你写好 java 代码，保存到硬盘当中。然后你在命令行中输入

javac YourClassName.java
此时，你的 java 代码就被编译成字节码（.class).如果你是在 Eclipse IDE 或者其他开发工具中，你保存代码的时候，开发工具已经帮你完成了上述的编译工作，因此你可以在对应的目录下看到 class 文件。此时的 class 文件依然是保存在硬盘中，因此，当你在命令行中运行

java YourClassName
就完成了上面红色方框中的工作。JRE 的来加载器从硬盘中读取 class 文件，载入到系统分配给 JVM 的内存区域–运行数据区（Runtime Data Areas). 然后执行引擎解释或者编译类文件，转化成特定 CPU 的机器码，CPU 执行机器码，至此完成整个过程。

接下来就重点研究一下类加载器究竟为何物？又是如何工作的？ 首先看一下来加载器的一些特点，有点抽象，不过总有帮助的。

》》层级结构 类加载器被组织成一种层级结构关系，也就是父子关系。其中，Bootstrap 是所有类加载器的父亲。如下图所示：

![](https://uploadimg.markbj.com/static/resource/image/book/448ec3bc258f11e79e8000163e13356e.png)

--Bootstrap class loader： 当运行 java 虚拟机时，这个类加载器被创建，它加载一些基本的 java API，
包括 Object 这个类。需要注意的是，这个类加载器不是用 java 语言写的，而是用 C/C++ 写的。 
--Extension class loader: 这个加载器加载出了基本 API 之外的一些拓展类，包括一些与安全性能相关的类。（目前了解得不是很深，只能笼统说，待日后再详细说明） 
--System Class Loader: 它加载应用程序中的类，也就是在你的 classpath 中配置的类。 
--User-Defined Class Loader: 这是开发人员通过拓展 ClassLoader 类定义的自定义加载器，加载程序员定义的一些类。

》》委派模式（Delegation Mode） 仔细看上面的层次结构，当 JVM 加载一个类的时候，
下层的加载器会将将任务委托给上一层类加载器，上一层加载检查它的命名空间中是否已经加载这个类，
如果已经加载，直接使用这个类。如果没有加载，继续往上委托直到顶部。检查完了之后，按照相反的顺序进行加载，
如果 Bootstrap 加载器找不到这个类，则往下委托，直到找到类文件。对于某个特定的类加载器来说，
一个 Java 类只能被载入一次，也就是说在 Java 虚拟机中，类的完整标识是（classLoader，package，className）。
一个雷可以被不同的类加载器加载。


![](https://uploadimg.markbj.com/static/resource/image/book/448ecab0258f11e79e8000163e13356e.png)

框图中各个步骤简单介绍如下：
Loading：文章前面介绍的类加载，将文件系统中的 Class 文件载入到 JVM 内存（运行数据区域） 
Verifying：检查载入的类文件是否符合 Java 规范和虚拟机规范。 
Preparing：为这个类分配所需要的内存，确定这个类的属性、方法等所需的数据结构。（Prepare a data structure that assigns the memory required by classes and indicates the fields,methods, and interfaces defined in the class.） 
Resolving：将该类常量池中的符号引用都改变为直接引用。（不是很理解） 
Initialing：初始化类的局部变量，为静态域赋值，同时执行静态初始化块。

那么，Class Loader 在加载类的时候，究竟做了些什么工作呢？ 要了解这其中的细节，必须得先详细介绍一下运行数据区域。

二、运行数据区域 Runtime Data Areas：当运行一个 JVM 示例时，系统将分配给它一块内存区域（这块内存区域的大小可以设置的），这一内存区域由 JVM 自己来管理。 
从这一块内存中分出一块用来存储一些运行数据，例如创建的对象，传递给方法的参数，局部变量，返回值等等。分出来的这一块就称为运行数据区域。
运行数据区域可以划分为6大块：Java 栈、程序计数寄存器（PC 寄存器）、本地方法栈（Native Method Stack）、Java 堆、方法区域、运行常量池（Runtime Constant Pool）。
运行常量池本应该属于方法区，但是由于其重要性，JVM 规范将其独立出来说明。其中，前面3各区域（PC 寄存器、Java 栈、本地方法栈）是每个线程独自拥有的，后三者则是整个 JVM 实例中的所有线程共有的。
这六大块如下图所示：
![](https://uploadimg.markbj.com/static/resource/image/book/448ed780258f11e79e8000163e13356e.png)

