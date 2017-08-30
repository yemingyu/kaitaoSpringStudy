package com.sjf.spring.test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.sjf.spring.bean.HelloWorld;

import cn.javass.spring.chapter2.helloworld.HelloApi;
 
/**
 * 测试类
 * @author sjf0115
 *
 */
public class Test {
 
	private static ApplicationContext context;
	private static HelloWorld helloWorld;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2. 从IOC容器中获取Bean实例
		helloWorld = (HelloWorld)context.getBean("helloworld");
		// 3.调用sayHello方法
		helloWorld.sayHello();
		
		context = new ClassPathXmlApplicationContext("helloworld.xml");  
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”  
         HelloApi helloApi = context.getBean("hello", HelloApi.class);  
         //3、执行业务逻辑  
         helloApi.sayHello(); 
         
         
       BeanFactory beanFactory =  new ClassPathXmlApplicationContext("constructorDepend.xml");  
       //获取根据参数索引依赖注入的Bean  
       HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);  
       byIndex.sayHello();  
       //获取根据参数类型依赖注入的Bean  
       HelloApi byType = beanFactory.getBean("byType", HelloApi.class);  
       byType.sayHello();  
       //获取根据参数名字依赖注入的Bean  
       HelloApi byName = beanFactory.getBean("byName", HelloApi.class);  
       byName.sayHello();  
         
	}
}