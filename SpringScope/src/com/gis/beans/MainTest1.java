package com.gis.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		HelloBean bean = (HelloBean) context.getBean("HelloBean");
		bean.setMsg("string");
		bean.HelloWorld();
		
		HelloBean bean2=(HelloBean) context.getBean("HelloBean");
		bean2.HelloWorld();
		
	}

}
