package com.gis.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class SimpleCar implements BeanNameAware, BeanFactoryAware {

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("received the beanFactory " + beanFactory);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("the name of the bean is " + name);
	}

	public String describe() {
		return "Car is an empty car";
	}
}
