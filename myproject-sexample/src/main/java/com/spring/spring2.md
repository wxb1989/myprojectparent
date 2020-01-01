
#为什么会出现spring-boot，以及是如何实现的？
你可以自己写一个类实现WebApplicationInitializer，来启动一个spring mvc容器，里面会调用DispatcherServlet
基于spi机制在servlet3.0之后javaee提出了一个很nb的规范，
那就是如果你的项目里的resource文件夹下面有个META-INF/services/javaxServletContainerinItializer文件里写了一个实现了ServletContainerInitializer的实现类，
那么容器在启动的时候必须调用onStartup方法，如果你的类上面加了@HandlesTypes注解WebApplicationInitializer接口的实现类,这样spring就完美解决了容器的启动方式。


spring容器实例化过程
1.扫描类 -> 2.解析类 -> 3.实例化成beandefintion -> 4.所有bd存在一个map里 -> 5.调用bean工厂的后置处理器 -> 6.验证这个对象是否符合要求
 -> 7.推断构造方法（spring最难的地方） -> 8.spring开始new对象反射 -> 9.合并缓存注册信息 -> 10.提前暴露自己 -> 11.判断是否要属性注入 
 -> 12.进行属性注入 -> 13.完成属性注入 -> 14.调用生命周期回掉方法  -> 15.调用所有的awre接口 -> 16.完成代理 -> 17.put到容器里 
 18.调用特定的方法回销毁
8到15步最重要

spring boot的启动流程
1.配置属性-> 2.获取监听器，发布应用开启事件监听（相当于web.xml文件里配置的spring的context listener） 3.初始化输入参数 
4.配置环境输入banner文件 5.创建上下文context 6.预处理上下文 7.刷新上下文 8.再刷新上下文 9.发布应用启动事件 10.发布应用启动事件完成 


tomcat的启动过程是spring boot先做应用类型推断分为三种应用类型（非web型、web型、web reactive型）内部依照tomcat的源码new了一个Tomcat类，然后在配置对应的service ,engine host context wrapper就相当于我们在tomcat的
xml文件里看到的那些节点一样