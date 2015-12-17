package com.gis.demo;

import java.io.IOException;

public class MainTest1 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		com.gis.components.SimpleComponent c = (com.gis.components.SimpleComponent) SimpleContainer
				.getBean("simpleComponent1");
		c.HelloWorld();
		System.in.read();
	}

}
