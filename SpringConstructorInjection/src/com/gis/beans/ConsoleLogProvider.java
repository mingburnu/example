package com.gis.beans;

public class ConsoleLogProvider implements ILogStorageProvider {

	@Override
	public void Add(String s) {
		System.out.println(s);

	}

}
