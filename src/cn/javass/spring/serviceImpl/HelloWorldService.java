package cn.javass.spring.serviceImpl;

import cn.javass.spring.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("============Hello World!");
	}

}
