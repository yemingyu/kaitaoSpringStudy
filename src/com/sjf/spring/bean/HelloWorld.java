package com.sjf.spring.bean;

public class HelloWorld {
	private String name1;
	 
	public void setName1(String name) {
		this.name1 = name;
	}
	
	public void sayHello(){
		System.out.println("welcome "+ name1 +" to spring world...");
	}
}
