package tw.leonchen.oop.inheritance;

class Parent {
	String name = "Dennis";

	void sayHello() {
		System.out.println("hello," + name);
	}

	public void sayGoodBye() {
		System.out.println("goodbye," + name);
	}
}

class Child extends Parent {
	public void play() {
		System.out.println("play");
	}
}

public class CallTestInheritanceEx1 {

	public static void main(String[] args) {
		Child child1 = new Child();
		child1.name = "Mike";
		child1.sayHello();
		child1.sayGoodBye();
		child1.play();
	}

}
