package com.gis.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {

	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "beans.config.xml");
		// HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		// obj.getMessage();
		// ((AbstractApplicationContext) context).registerShutdownHook();
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}

}
