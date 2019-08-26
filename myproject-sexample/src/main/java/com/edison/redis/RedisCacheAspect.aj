package com.edison.redis;

import com.edison.util.SpringExpressionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @package com.edison.redis
 * @description redis 缓存切面
 * @author
 * @create 2019-08-19 15:31
 * https://www.jb51.net/article/144943.htm
 **/
@Aspect
@Component
public class RedisCacheAspect {

    /**
     * 这块可配置，每个公司都要自己的缓存配置方式，到时候可配置自己公司所用的缓存框架和配置方式
     */
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    /**
     * 具体的方法
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.edison.redis.RedisCache)")
    public Object cache(JoinPoint joinPoint) throws Throwable {
        System.out.println("自定义注解执行了...");
        /**
         * 确定redis的 key 和 value
         * key : 类名 + 方法名 + 参数列表(确定唯一的key)
         * value : 对象序列化的的byte数组(redis天然支持byte数组)
         */
        String className = joinPoint.getTarget().getClass().getName();      //类名
        String methodName = joinPoint.getSignature().getName();             //方法名

        // 得到类名、方法名和参数
        Object[] args = joinPoint.getArgs();

        //获取实现类的方法
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        //注解信息 key
        String key = cacheable.key();

        //是否转换成md5值
        boolean keyTransformMd5 = cacheable.keyTransformMd5();
        //----------------------------------------------------------
        // 用SpEL解释key值
        //----------------------------------------------------------
        //解析EL表达式后的的redis的值
        String keyVal = SpringExpressionUtils.parseKey(key, method, joinPoint.getArgs(), keyTransformMd5);


        // 获取目标对象
        Object target = joinPoint.getTarget();
        //这块是全路径包名+目标对象名 ，默认的前缀，防止有的开发人员乱使用key，乱定义key的名称，导致重复key，这样在这加上前缀了，就不会重复使用key
        String target_class_name = target.getClass().getName();
        StringBuilder redis_key = new StringBuilder(target_class_name);
        redis_key.append(keyVal);

        //最终的redis的key
        String redis_final_key = redis_key.toString();
        String value = valueOperations.get(redis_final_key);

        if (value == null) {
            //这块是判空
            // 缓存未命中，这块没用log输出，可以自定义输出
            System.out.println(redis_final_key + "缓存未命中缓存");

            // 如果redis没有数据则执行拦截的方法体
            result = joinPoint.proceed(args);

            //存入json格式字符串到redis里
            String result_json_data = JSONObject.valueToString(result);
            System.out.println(result_json_data);
            // 序列化结果放入缓存
            valueOperations.set(redis_final_key, result_json_data, getExpireTimeSeconds(cacheable), TimeUnit.SECONDS);
        } else {
            // 缓存命中，这块没用log输出，可以自定义输出
            System.out.println(redis_final_key + "命中缓存，得到数据");

            // 得到被代理方法的返回值类型
            Class<?> returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();

            //拿到数据格式
            result = getData(value, returnType);
        }
        return result;
    }
}
