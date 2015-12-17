package com.gis.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainTest1 {

	public static void main(String[] args) {
		final XmlBeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("beans.config.xml"));
		SimpleCar car = (SimpleCar) beanFactory.getBean("bustedCar");
		car.setBeanName("beanName");
		System.out.println(car.describe());
	}
}
