package com.gis.beans;

public class HelloBean {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void HelloWorld() {
		System.out.println(msg);
	}

	public HelloBean() {
		System.out.println("Bean is Created!");
	}

}
