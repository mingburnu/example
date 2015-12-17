package com.gis.beans;

import java.util.Date;

public class HelloBean {
	private String _msg;

	public void HelloWorld() {
		System.out.println(_msg);
	}

	public HelloBean(String s) {
		_msg = s;
	}
	public HelloBean(Date d){
		_msg=d.toString();
	}
	public HelloBean(Date d,String s){
		_msg=d.toString() + "---" +s;
	}
}
