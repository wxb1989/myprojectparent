# myprojectparent
该项目主要包含jse的基础语法和一些自己练习数据结构和设计模式的代码，以及其他一些util的用法
#my-starter
该项目是自定义的spring-boot-starter
#demo assembly打包执行的命令
mvn demo clean package assembly:single -Dmaven.test.skip=true



使用这种依赖管理机制似乎不能减少太多的POM配置，
就少了version(junit还少了个scope)，感觉没啥作用呀；
其实作用还是挺大的，
父POM使用dependencyManagement能够统一项目范围中依赖的版本，
当依赖版本在父POM中声明后，子模块在使用依赖的时候就无须声明版本，
也就不会发生多个子模块使用版本不一致的情况，帮助降低依赖冲突的几率。
如果子模块不声明依赖的使用，
即使该依赖在父POM中的dependencyManagement中声明了，也不会产生任何效果。

https://gitee.com/52itstyle/spring-boot-blog/tree/master 

#技术博客：
https://blog.51cto.com/14480698/p1   .....
https://www.jianshu.com/u/81cab6a91a0a

https://www.jianshu.com/p/2a61a29662c6
spring + boot+ cloud  https://mp.weixin.qq.com/s/N507Cfb_mbkGvHtg_FIaVg 

