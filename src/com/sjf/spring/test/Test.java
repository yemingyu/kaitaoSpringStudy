package com.sjf.spring.test;
import org.junit.Assert;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.sjf.spring.bean.HelloWorld;

import cn.javass.spring.bean.ListTestBean;
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
         
         
//       BeanFactory beanFactory =  new ClassPathXmlApplicationContext("constructorDepend.xml");  
//       //获取根据参数索引依赖注入的Bean  
//       HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);  
//       byIndex.sayHello();  
//       //获取根据参数类型依赖注入的Bean  
//       HelloApi byType = beanFactory.getBean("byType", HelloApi.class);  
//       byType.sayHello();  
//       //获取根据参数名字依赖注入的Bean  
//       HelloApi byName = beanFactory.getBean("byName", HelloApi.class);  
//       byName.sayHello();  
         
//         BeanFactory beanFactory =  new ClassPathXmlApplicationContext("staticFactoryDependencyInject.xml");  
//         //获取根据参数索引依赖注入的Bean  
//         HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);  
//         byIndex.sayHello();  
//         //获取根据参数类型依赖注入的Bean  
//         HelloApi byType = beanFactory.getBean("byType", HelloApi.class);  
//         byType.sayHello();  
//         //获取根据参数名字依赖注入的Bean  
//         HelloApi byName = beanFactory.getBean("byName", HelloApi.class);  
//         byName.sayHello(); 
         
//         BeanFactory beanFactory =  new ClassPathXmlApplicationContext("DependencyInjectByInstanceFactory.xml");  
//         //获取根据参数索引依赖注入的Bean  
//         HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);  
//         byIndex.sayHello();  
//         //获取根据参数类型依赖注入的Bean  
//         HelloApi byType = beanFactory.getBean("byType", HelloApi.class);  
//         byType.sayHello();  
//         //获取根据参数名字依赖注入的Bean  
//         HelloApi byName = beanFactory.getBean("byName", HelloApi.class);  
//         byName.sayHello(); 
         
//         BeanFactory beanFactory =  
//        		 new ClassPathXmlApplicationContext("setterDependencyInject.xml");  
//        		    HelloApi bean = beanFactory.getBean("bean", HelloApi.class);  
//        		     bean.sayHello();
         
//         BeanFactory beanFactory =  
//        		 new ClassPathXmlApplicationContext("listInject.xml");  
//        		 ListTestBean listBean = beanFactory.getBean("listBean", ListTestBean.class);  
//        		 System.out.println(listBean.getValues().size());  
//        		 listBean.printValues();
//        		 Assert.assertEquals(3, listBean.getValues().size());
         
//         ApplicationContext parentBeanContext =  
//        		 new ClassPathXmlApplicationContext("setterDependencyInject.xml");  
//        		 //初始化当前容器  
//        		 ApplicationContext beanContext = new ClassPathXmlApplicationContext(  
//        		 new String[] {"setterDependencyInject.xml"}, parentBeanContext);  
//        		     HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);  
//        		     bean1.sayHello();//该Bean引用local bean  
//        		 HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);  
//        		 bean2.sayHello();//该Bean引用parent bean
         
         ApplicationContext parentBeanContext =  
        		 new ClassPathXmlApplicationContext("parentBeanInject.xml");  
        		 //初始化当前容器  
        		 ApplicationContext beanContext = new ClassPathXmlApplicationContext(  
        		 new String[] {"localBeanInject.xml"}, parentBeanContext);  
        		     HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);  
        		     bean1.sayHello();//该Bean引用local bean  
        		 HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);  
        		 bean2.sayHello();//该Bean引用parent bean
	}
}