package com.gis.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigableContainer {
	private static HashMap<String, Object> _resposity = new HashMap<String, Object>();
	private static Properties _props = new Properties();

	public static void setBean(String name, Object value) {
		if (!_resposity.containsKey(name)) {
			_resposity.put(name, value);
		}
	}

	public static Object getBean(String name) {
		if (_resposity.containsKey(name)) {
			return _resposity.get(name);
		} else {
			String classForLoad = _props.getProperty(name);
			if (classForLoad != null) {
				try {
					return Class.forName(classForLoad).newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	static {
		try {
			_props.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}