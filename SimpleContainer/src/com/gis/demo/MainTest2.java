package com.gis.demo;

import java.io.IOException;

public class MainTest2 {

	public static void main(String[] args) throws IOException {
		com.gis.components.SimpleComponent c = (com.gis.components.SimpleComponent) ConfigableContainer.getBean("SimpleComponet");
		c.HelloWorld();
		System.in.read();		
	}
}
