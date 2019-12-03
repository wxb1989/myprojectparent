package com.edison.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.ExpressionParser;
import java.lang.reflect.Method;

/**
 * spring EL表达式
 * 
 */
public class SpringExpressionUtils {

 /**
  * 获取缓存的key key 定义在注解上，支持SPEL表达式 注： method的参数支持Javabean和Map
  * method的基本类型要定义为对象，否则没法读取到名称
  *
  * example1: Phone phone = new Phone(); "#{phone.cpu}" 为对象的取值 、
  * example2: Map apple = new HashMap(); apple.put("name","good apple"); "#{apple[name]}" 为map的取值 
  * example3: "#{phone.cpu}_#{apple[name]}"
  * 
  *
  * @param key
  * @param method
  * @param args
  * @return
  */
 public static String parseKey(String key, Method method, Object[] args, boolean keyTransformMd5) {
  // 获取被拦截方法参数名列表(使用Spring支持类库)
  LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
  String[] paraNameArr = u.getParameterNames(method);

  // 使用SPEL进行key的解析
  ExpressionParser parser = new SpelExpressionParser();
  // SPEL上下文
  StandardEvaluationContext context = new StandardEvaluationContext();
  // 把方法参数放入SPEL上下文中
  for (int i = 0; i < paraNameArr.length; i++) {
   context.setVariable(paraNameArr[i], args[i]);
  }
  ParserContext parserContext = new TemplateParserContext();

  // ----------------------------------------------------------
  // 把 #{ 替换成 #{# ,以适配SpEl模板的格式
  // ----------------------------------------------------------
  //例如，@注解名称(key="#{player.userName}",expire = 200)
  //#{phone[cpu]}_#{phone[ram]}
  //#{player.userName}_#{phone[cpu]}_#{phone[ram]}_#{pageNo}_#{pageSize}
  Object returnVal = parser.parseExpression(key.replace("#{", "#{#"), parserContext).getValue(context, Object.class);

  //这块这么做，是为了Object和String都可以转成String类型的，可以作为key
  String return_data_key = JSONObject.toJSONString(returnVal);
  //转换成md5，是因为redis的key过长，并且这种大key的数量过多，就会占用内存，影响性能
  if(keyTransformMd5) {
   return_data_key = MD5.getMD5(return_data_key);
  }

  return returnVal == null ? null : return_data_key;
 }
}