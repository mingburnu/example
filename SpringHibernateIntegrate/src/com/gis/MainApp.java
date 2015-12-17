package com.gis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) throws ClassNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		UserDAO dao = (UserDAO) context.getBean("UserDAO");
		for (USER u : dao.getByName("code6421"))
			System.out.println(u.getNAME());
	}
}