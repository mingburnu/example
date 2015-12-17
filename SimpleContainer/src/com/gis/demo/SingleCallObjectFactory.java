package com.gis.demo;

public class SingleCallObjectFactory implements IObjectFactory {
private Object _instance=null;
	@Override
	public Object CreateInstance(String className) {
		if(_instance==null)
		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return _instance;
	}

	@Override
	public void Release(Object o) {
	}
}
