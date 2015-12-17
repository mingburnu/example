package tw.leonchen.oop.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TestSerializeEx1 implements Serializable{
	String name = "mary";
	
	public void sayHello(){
		System.out.println("hello," + name);
	}
}

class TestSerializeEx1_Execute{
	public void storeObject() throws Exception{
		TestSerializeEx1 serial = new TestSerializeEx1();		
		ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("d:/temp/objectStore.txt"));
		oos1.writeObject(serial);
		oos1.close();
	}
	
	public Object retrieveObject() throws Exception{
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("d:/temp/objectStore.txt"));
		return ois1.readObject();
	}
}

public class CallTestSerializeEx1 {

	public static void main(String[] args) throws Exception {
		TestSerializeEx1_Execute exec = new TestSerializeEx1_Execute();
		exec.storeObject();
		
		TestSerializeEx1 obj1 = (TestSerializeEx1)exec.retrieveObject();
		obj1.sayHello();
	}

}
