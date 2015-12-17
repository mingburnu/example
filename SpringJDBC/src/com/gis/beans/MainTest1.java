package com.gis.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		UserDAO bean = (UserDAO) context.getBean("UserDAO");
		User data = bean.getUserById(2);
		System.out.println(data.getName());
	}
}
