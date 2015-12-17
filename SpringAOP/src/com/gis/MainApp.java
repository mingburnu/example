package com.gis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) throws ClassNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		UserDAO dao = (UserDAO) context.getBean("UserDAO");
		dao.getByName("code6421");
		USER u=new USER();
		u.setNAME("code6426");				
		dao.Insert(u);
		System.out.println(u.getNAME());
	}
}