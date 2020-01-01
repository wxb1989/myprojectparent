
#spring原码分析
https://blog.csdn.net/nuomizhende45/article/details/81158383 这篇文章也做了讲解
DefaultListableBeanFactory 这个bean工厂是spring里最实现和继承最多接口和类的类
1、scam扫描定义的包
2、解析扫描到的包下面的对象
4、初始化beanfactory spring 放到factory的map里去
下面有两个流程 :如果程序没有提供实现BeanFactoryPostProcessor的实现类走5.1否则走5.2
5.1、加载完成之后
5.2、执行程序定义的BeanFactoryPostProcessor里的方法,
去操作DefaultListableBeanFactory里的beanMap(主流框架都是通过这个方法来修改beanMap,做自己的事情)-
还可以实现BeanDefinitionRegistryPostProcessor,
也就是既可以实现BeanFactoryPostProcessor也可以实现BeanDefinitionRegistryPostProcessor,
提倡实现BeanDefinitionRegistryPostProcessor这个类

6、spring获取到beanMap里的bean,执行程序要做的事情(单例)


#第二步解析对象骤 的描述 :spring解析bean的时候要了解DeanDefinition概念十分重要
BeanDefinition是用来描述spring里扫描出来的java对象
例如:BeanDefinition里有className  scope(作用域) 还有其他很多东西 



#spring beanFactory的onrefash方法解释
要了解spring的9个后置处理器 FactoryBean和BeanFactory
BeanFactoryPostProcessor 
实现这个接口可以 自己实现和修改spring容器里的bean替换成没有注入进去的bean

#spring的拓展点
1.继承BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry 
  1.1BeanDefinitionRegistryPostProcessor接口在读取项目中的beanDefinition之后执行，提供的一个补充扩展接口，用来动态注册beanDefinition.
    @Component
    public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("postProcessBeanDefinitionRegistry ...");
            //手动注册 beanDefinition
            registry.registerBeanDefinition("myBeanDefinitionRegistrar",new AnnotatedGenericBeanDefinition(MyBeanDefinitionRegistrar.class));
        }
    }

2.BeanFactoryPostProcessor和BeanPostProcessor 接口比较相似，从字面不难看出，前者多了一个 factory，所以该接口正是beanFactory的扩展接口，
    使用场景：一般用来在读取所有的beanDefinition信息之后，实例化之前，通过该接口可进一步自行处理，比如修改beanDefinition等。
       @Component
       public class MyBeanDefinitionRegistryPostProcessor implements BeanFactoryPostProcessor {
           @Override
           public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
               BeanDefinition myBeanDefinitionRegistrar = beanFactory.getBeanDefinition("myBeanDefinitionRegistrar");
               //可以修改 beanDefinition 信息。这里将bean 设置为单例
               myBeanDefinitionRegistrar.setScope(BeanDefinition.SCOPE_SINGLETON);
           }
       }
       
3.继承InstantiationAwareBeanPostProcessor接口实现postProcessAfterInstantiation方法在AbstractAutowireCapableBeanFactory.populateBean()填充方法中会触发
可以控制某个spring里的类在自己手上控制,该方法默认返回为true，如果返回false，则中断populateBean方法，即不再执行属性注入的过程


4.InstantiationAwareBeanPostProcessor.postProcessPropertyValues
    该方法用于属性注入，在 bean 初始化阶段属性填充时触发。@Autowired，@Resource 等注解原理基于此方法实现。
    具体调用点在AbstractAutowireCapableBeanFactory中populateBean方法
    
    
5.ApplicationContextAwareProcessor.invokeAwareInterfaces
  该扩展点用于执行各种驱动接口。在 bean实例化之后，属性填充之后，通过扩展接口
  
  @Component
  public class MyComponent implements ApplicationContextAware, InitializingBean, BeanClassLoaderAware ,ResourceLoaderAware,EnvironmentAware {
      @Override
      public void afterPropertiesSet() throws Exception {
          System.out.println("afterPropertiesSet init...");
      }
      @Override
      public void setBeanClassLoader(ClassLoader classLoader) {
          System.out.println("setBeanClassLoader init...");
      }
      @Override
      public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          System.out.println("setApplicationContext init...");
      }
      @Override
      public void setEnvironment(Environment environment) {
          System.out.println("setEnvironment init...");
      }
      @Override
      public void setResourceLoader(ResourceLoader resourceLoader) {
          System.out.println("setResourceLoader init...");
      }
  }
  
  
  
6.BeanFactoryPostProcessor.postProcessAfterInitialization
    该方法Spring IOC过程中最后一个常用的扩展点，用于 bean 初始化之后的后置处理。IOC 流程执行到此处，一个完整的 bean 已经创建结束，
    可在此处对 bean 进行包装或者代理。Spring AOP 原理便是基于此扩展点实现




