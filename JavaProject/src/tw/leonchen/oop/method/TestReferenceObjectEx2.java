package tw.leonchen.oop.method;

class Person
{
  public void sayHello()
  {
	 System.out.println("hello"); 
	 sayGoodBye();
  }
  
  public void sayGoodBye(){
	  System.out.println("GoodBye");
  }
}

public class TestReferenceObjectEx2 {

	public static void main(String[] args) {
		Person mike	= new Person();
		mike.sayHello();
		//mike.sayGoodBye();
		System.out.println("finished");
	}
}
