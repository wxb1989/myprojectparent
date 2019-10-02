package com.edison.configuration;

import com.edison.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @package com.edison.configuration
 * @description
 * @create 2019-09-18 14:43
 *
 * @ConditionalOnBean:当容器中有指定的Bean的条件下
 * @ConditionalOnClass：当类路径下有指定的类的条件下
 * @ConditionalOnExpression:基于SpEL表达式作为判断条件
 * @ConditionalOnJava:基于JVM版本作为判断条件
 * @ConditionalOnJndi:在JNDI存在的条件下查找指定的位置
 * @ConditionalOnMissingBean:当容器中没有指定Bean的情况下
 * @ConditionalOnMissingClass:当类路径下没有指定的类的条件下
 * @ConditionalOnNotWebApplication:当前项目不是Web项目的条件下
 * @ConditionalOnProperty:指定的属性是否有指定的值
 * @ConditionalOnResource:类路径下是否有指定的资源
 * @ConditionalOnSingleCandidate:当指定的Bean在容器中只有一个，或者在有多个Bean的情况下，
 *  用来指定首选的Bean @ConditionalOnWebApplication:当前项目是Web项目的条件下
 *
 *
 *  使用在application.yml 配置文件中添加配置信息：
 * example
 *   service
 *     enabled: true
 *     config： abc-des-dde,SSS-DRS-RE,SDR-SDFR-XXX
 **/
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    StarterService starterService (){
        return new StarterService(properties.getConfig());
    }
}
