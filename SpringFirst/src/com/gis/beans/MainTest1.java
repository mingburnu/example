package com.gis.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainTest1 {

	public static void main(String[] args) {
		// BeanDefinitionRegistry reg =new DefaultListableBeanFactory();
		// PropertiesBeanDefinitionReader reader= new
		// PropertiesBeanDefinitionReader(reg);
		// reader.loadBeanDefinitions(new
		// ClassPathResource("beans.properties"));
		// BeanFactory factory =(BeanFactory) reg;
		// HelloBean bean =(HelloBean) factory.getBean("HelloBean");
		// bean.HelloWorld();
		Resource rs = new ClassPathResource("beans.config.xml");
		BeanFactory factory = new XmlBeanFactory(rs);
		WorldBean bean = (WorldBean) factory.getBean("HelloBean");
		bean.HelloWorld();
	}
}
