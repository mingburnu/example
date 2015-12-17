package com.gis.beans;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class HelloBean implements MessageSourceAware {
	private MessageSource msgSource;

	public void HelloWorld() {
		System.out.println(msgSource.getMessage("HelloMsg", null,
				Locale.getDefault()));
	}

	@Override
	public void setMessageSource(MessageSource ms) {
		this.msgSource = ms;

	}

}
