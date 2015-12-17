package tw.leonchen.oop.encapsulation;

class TestSingletonEx1{
	private static final TestSingletonEx1 refObj = new TestSingletonEx1();  //Singleton
	
	String name = "mary";
	
	private TestSingletonEx1(){		
	}
	
	public void sayHello(){
		System.out.println("hello," + name);
	}
	
	public static TestSingletonEx1 getObject1(){
		TestSingletonEx1 test1 = new TestSingletonEx1();
		return test1;
	}
	
	public static TestSingletonEx1 getObject2(){
		return refObj;
	}
}

public class CallTestSingletonEx1 {

	public static void main(String[] args) {
		TestSingletonEx1 obj1 = TestSingletonEx1.getObject2();
		obj1.name="john";
		obj1.sayHello();
        System.out.println("finished");
	}

}
