package com.gis.demo;

public interface IObjectFactory {
public Object CreateInstance(String className);
public void Release(Object o);
}
