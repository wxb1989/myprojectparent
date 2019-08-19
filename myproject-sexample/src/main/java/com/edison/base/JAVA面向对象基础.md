#封装的原则
要求使对象之外的部分不能随意存取对象的内部数据，从而有效避免了错误对它的“交叉感染”，使软件错误能局部化，降低排错难度

#继承
所有的类都继承自 java.lang.Object，一些常用的方法：

equals():比较两个对象引用时否相同。

getClass():返回对象运行时所对应的类的表示，从而得到相应的信息

toString():返回对象字符串表示

finalize():用于在垃圾收集前清除对象

notify(), notifyall(), wait(): 用于多线程处理中的同步

子类（subclass）对父类（superclass，超类）的继承

子类不能继承父类中访问权限为 private 的成员变量和方法。

子类可以重写父类的方法，及命名与父类同名的成员变量。

Java 不支持多重继承

创建子类

#多态性
子类继承父类后，同一个方法有不同的表现

体现在两个方面：方法重载实现的静态多态性（编译时多态），方法重写实现的动态多态性（运行时多态）

重写方法的调用原则：子类重写父类的方法，调用子类方法；反之，调用父类的方法

一个对象可以引用子类的实例来调用子类的方法

eg: B 继承 A，A 的对象 a 引用 B 的实例，调用 B 的方法 callme()

import java.io.*;
class A {
    void callme() {
        System.out.println("Inside A's callme()) method");
    }
}
class B extends A {
    void callme() {
        System.out.println("Inside B's callme() method");
    }
}
public class Dispatch {
    public static void main(String args[]) {
        A a = new B(); // 引用子类的实例
        a.callme(); 
    }
}

#类的实现
 类声明
 　[public][abstract|final] class className [extends superclassName] [implements interfaceNameList] {
 
 }
 
 类体
 
 　　　　class className
 　　　　{
 　　　　　　[public | protected | private] [static] [final] [transient] [volatile] type variableName; // 成员变量
 　　　　　　[public | protected | private] [static] [final | abstract] [native] [synchronized] returnType methodName(
 　　　　　　　　[paramList]) [throws exceptionList] {statements}; //成员方法
 　　　　}
 成员变量
 
 　　　　[public | protected | private] [static] [final] [transient] [volatile] type variableName; // 成员变量
 　　　　　　static: 静态变量（类变量）
 　　　　　　final: 常量
 　　　　　　transient：暂时性变量，用于对象存档
 　　　　　　volatile：共享变量，用于并发线程的共享
 成员方法
 
 　　　　[public | protected | private] [static] [final | abstract] [native] [synchronized] returnType methodName(
 　　　　[paramList]) [throws exceptionList] {statements}; //成员方法
 　　　　　　static: 类方法，可通过类名直接调用
 　　　　　　abstract: 抽象方法，没有方法体
 　　　　　　final：方法不能被重写
 　　　　　　native：集成其他语言的代码
 　　　　　　synchronized：控制多个并发线程的访问
 
 #抽象类和抽象方法：
 用 abstract 关键字修饰类:抽象类
 
 用 abstract 关键字修饰方法：抽象方法
 
 抽象类必须被继承，抽象方法必须被重写
 
 抽象方法只需声明，无需实现
 
 抽象类不能被实例化，抽象类不一定要包含抽象方法
 
 若类中包含抽象方法，给类必须被定义为抽象类
 
 #接口
  接口是抽象类的一种，只包含常量和方法的定义，没有变量和方法的实现，且其方法都是抽象方法。
  
  用处体现在：
  
  通过接口，实现不相关类的相同行为
  
  通过接口，指明多个类需要实现的方法
  
  通过接口，了解对象的交互界面，无需了解对象所对应的类