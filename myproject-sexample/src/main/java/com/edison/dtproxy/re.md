#动态代理的三种实现方式
原理：利用反射去调方法，Proxy这个类就是java.lang.reflect包下面的

拿到被代理类的class对象 --target

动态生成一个代理类CLASSA（class com.sun.proxy.$Proxy3），这类实现被代理类的所有接口

获取这个CLASSA的一个参数为InvocationHandler的构造方法

调用这个构造方法创建实例（这个就是代理对象）；参数就是这个代理类WorkerProxy
