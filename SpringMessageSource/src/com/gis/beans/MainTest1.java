package com.gis.beans;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		System.out.println(context.getMessage("HelloMsg", null,
				Locale.TRADITIONAL_CHINESE));
		System.out.println(context.getMessage("HelloMsg", null,
				Locale.US));
	}

}
