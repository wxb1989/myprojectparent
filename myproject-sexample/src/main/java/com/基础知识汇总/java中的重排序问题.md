java中的重排序问题
1. 什么是重排序
在执行程序时, 处理器和编译器常常会修改指令的执行顺序以达到提高性能的目标。 但是也不能随意重排序，需要满足两个条件:

在单线程环境下不能改变运行结果
存在依赖关系的指令不能重排序
2. 为什么会乱序
现在的cpu一般采用流水线来执行指令, 多条指令可以同时存在于流水线中，同时被执行
流水线是并行的，A指令在B指令之前，也可能会出现A和B同时执行的情况, 极大提高执行效率
cpu其实是顺序去取指令的，但是指令执行的各种条件以及相互影响导致指令乱序执行完成,即 顺序流入，乱序流出
相对于cpu的乱序,编译器的乱序才是真乱序，不过也是在保证最终结果不变的前提下进行的
3. 指令重排序类型
源代码 -> 编译器优化重排序 -> 指令级并行重排序 -> 内存系统重排序 -> 最终执行的指令序列

4. 重排序问题复现
public class Test {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread A = new Thread(() -> {
                //由于线程A先启动，下面这句话让它等一等线程B. 读着可根据自己电脑的实际性能适当调整等待时间.
                shortWait(100000);
                a = 1;
                x = b;
            });

            Thread B = new Thread(() -> {
                b = 1;
                y = a;
            });
            A.start();
            B.start();
            A.join();
            B.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            }
        }
    }


    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
上述代码只会在发生重排序的时候，才可能出现 x=0,y=0的结果,

输出x=0 需要 A线程的 x=b 发生在 B线程的 b=1 之前, 而要输出 y=0 又需要 B线程的 y=a 发生在A线程的a=1之前

所以只能是先执行完 x=b 和 y=a后才能执行 a=1 和 b=1, 只有重排序后才可能发生, 就像下面这些情况

线程A顺序执行, 线程B重排序执行
Time	Thread-A	Thread-B
T1		y=a
T2	a=1	
T3	x=b	
T4		b=1
线程A重排序执行, 线程顺序执行
Time	Thread-A	Thread-B
T1	x=b	
T2		b=1
T3		y=a
T4	a=1	
线程A重排序执行, 线程B重排序执行
Time	Thread-A	Thread-B
T1	x=b	
T2		y=1
T3		b=1
T4	a=1	
5. JMM内存屏障指令
内存屏障(Memory Barrier) 是一种cpu指令, 用于控制特定条件下的重排序和内存可见性问题。 JMM把内存屏障指令分为以下四类:

屏障类型	指令示例	说明
LoadLoad Barriers	Load1; LoadLoad; Load2	确保Load1的数据装载完成, 再进行后续装载指令的执行
StoreStore Barriers	Store1; StoreStore; Store2	确保Store1数据对其他处理器可见(刷新到内存), 再进行后续存储指令的执行
LoadStore Barriers	Load1; LoadStore; Store2	确保Load1的数据装载完成，再进行后续存储指令的执行
StoreLoad Barriers	Store1; StoreLoad; Load2	确保屏障之前的所有指令都执行完再进行
StoreLoad Barriers是一个全能型的屏障，大多数处理器都支持。 执行该屏障的开销会很昂贵，因为当前处理器需要把缓冲区中的数据全部刷新到内存中

6. as-if-serial语义
简单来讲，as-if-serial语义是指无论怎么重排序都不能改变程序的执行结果(单线程状态下)。 编译器和处理器都必须遵守as-if-serial语义

7. happens-before
8. final