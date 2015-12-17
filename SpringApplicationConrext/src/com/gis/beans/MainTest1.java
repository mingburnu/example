package com.gis.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainTest1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
	HelloBean bean =(HelloBean) context.getBean("HelloBean");
	bean.HelloWorld();
	
	ApplicationContext context2 = new ClassPathXmlApplicationContext(
			"beans.config.xml");
	LogBean bean2=(LogBean) context2.getBean("LogBean");
	bean2.Log("Hello World");
	}

}
