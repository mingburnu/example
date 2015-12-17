package com.gis.beans;

import java.util.Date;

public class HelloBean {
	private String _msg;	

	public void setMsg(String value) {
		_msg = value;
	}
	public void HelloWorld() {
System.out.println(_msg);
	}
	
	public HelloBean() {
		
	}
}
