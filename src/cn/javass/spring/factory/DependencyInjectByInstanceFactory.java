package cn.javass.spring.factory;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter2.helloworld.HelloImpl3;

public class DependencyInjectByInstanceFactory {
	public HelloApi newInstance(String message, int index) {  
        return new HelloImpl3(message, index);  
    }  
}
