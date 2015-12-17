package com.gis.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainTest1 {

	public static void main(String[] args) {
		Resource rs=new ClassPathResource("beans.config.xml");
		BeanFactory factory=new XmlBeanFactory(rs);
		AreaBean bean=(AreaBean) factory.getBean("AreaBean");
		for(CityBean s : bean.getArea())
		System.out.println(s.getCity());
	}

}
