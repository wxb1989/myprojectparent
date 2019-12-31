需要加volidate修饰符
初始化user这一步实际上可以分为如下三个步骤

分配内存空间
初始化对象
将user引用指向内存空间
但是编译器有可能将第二步和第三步进行重排序,实际执行步骤变成下面这样

分配内存空间
将user引用指向内存空间
初始化对象

 推荐的写法
public class Something {
    private Something() {}
    private static class LazyHolder {
        static final Something INSTANCE = new Something();
    }
    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }
}
静态内部类 LazyHolder只会在JVM判断一定要被执行的时候才会进行初始化(保证懒加载)
INSTANCE会作为LazyHolder的静态变量在LazyHolder加载的时候被执行
JLS(java语言规范)保证类的初始化过程是串行的(没有线程安全的问题)，这样的话就保证了线程安全的问题
需要注意的是, Something的构造方法执行过程中不能失败,否则会报 NoClassDefFoundError 错误

或者使用emua的写法
public enum SingletonEnum{
    INSTANCE;
}
public enum SingletonEnum { 
INSTANCE; int value; 
// 这里我们可以自定义构造函数. 
private SingletonEnum() { 
value = 1; System.out.println("INSTANCE now created!"); 
} 
public int getValue() { 
return value; 
} public void setValue(int value) {
 this.value = value;
  } 
}
