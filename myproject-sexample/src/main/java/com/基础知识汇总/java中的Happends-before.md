什么是Happends-before
Happends-before关系主要是描述多线程操作的可见性，如果A操作应该在B操作之前(无论执行多少次，A总是比B先执行)，那么A应该 Happends-before B(也可以标记为 hb(A,B)), 即A和B有Happends-before关系。
Happends-before是JMM对可见性问题的内置解决方案(加锁也是一种解决方案)

2. Happends-before具体规则
happends-before定义

1.如果一个操作happends-before另一个操作,那么第一个操作的执行结果将对第二个操作可见，而且第一个操作的执行顺序排在第二个操作之前。
2.两个操作之间存在happens-before关系，并不意味着一定要按照happens-before原则制定的顺序来执行。如果重排之后的执行结果与按照happens-before关系来执行的结果一致，那么这种重排序也是合法的。


happends-before规则
单线程规则: 单线程里面的每个动作都对之后的动作可见。
竞争锁规则: 如果t1释放锁 (或者离开synchronized代码块), t2获得同一个锁, 那么t2能看到t1的所有写操作。
volatile变量规则: 线程1写入了volatile变量v, 接着线程2读取了变量v, 那么线程2写入的v以及之前的写操作对线程2都是可见的。
线程启动规则: 如果在t1里面启动了一个新线程t2, 那么t1线程里t2.start()之前的写操作, 对t2是可见的.
线程join规则: 如果线程t2里面调用了线程t1的join方法, 那么t1线程里面的所有写操作都对t2可见。
传递性: hb(A,B) && hb(B,C) -> hb(A,C)。