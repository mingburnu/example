package com.gis.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MAinTest1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		System.out.println("context is created!");
		HelloBean bean = (HelloBean) context.getBean("HelloBean");
		bean.HelloWorld();
	}

}
