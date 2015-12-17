package com.gis.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainTest1 {

	public static void main(String[] args) {
		Resource rs=new ClassPathResource("beans.config.xml");
		BeanFactory factory=new XmlBeanFactory(rs);
		LogBean bean=(LogBean) factory.getBean("LogBean");
		bean.Log("Hello World");

	}

}
