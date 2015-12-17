package tw.leonchen.oop.io;

import java.util.Enumeration;
import java.util.Properties;

public class TestPropertiesEx1 {

	public static void main(String[] args) {
		Properties p1 = System.getProperties();
        Enumeration<?> keys = p1.propertyNames();
        
        while(keys.hasMoreElements()){
        	String key = (String)keys.nextElement();
        	String value = p1.getProperty(key);
        	System.out.println(key + ":" + value);
        }
	}

}
