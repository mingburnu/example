package com.gis.beans;

public class LogBean {
private ILogStorageProvider _provider=null;
public LogBean(ILogStorageProvider provider){
	_provider= provider;
}
public void Log(String msg){
	_provider.Add(msg);
}
}
