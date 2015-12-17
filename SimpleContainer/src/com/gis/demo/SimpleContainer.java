package com.gis.demo;

import java.util.HashMap;

public final class SimpleContainer {
	private static HashMap<String, Object> _resposity = new HashMap<String, Object>();

	public static void setBean(String name, Object value) {
		if (!_resposity.containsKey(name)) {
			_resposity.put(name, value);
		}
	}
public static Object getBean(String name){
if(_resposity.containsKey(name)){
	return _resposity.get(name);
}
	return null;	
}
static{
	com.gis.components.SimpleComponent c= new com.gis.components.SimpleComponent();
	SimpleContainer.setBean("simpleComponent1", c);
	
}
}
