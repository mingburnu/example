package tw.leonchen.oop.override;

class Animal {
	public void eat() {
		System.out.println("eat food");
	}
}

class Sheep extends Animal {

	public void eat() {
		System.out.println("eat grass");
	}
}

class Lion extends Animal {
	public void eat() {
		System.out.println("eat meat");
	}
}

class Monkey extends Animal {
	public void eat() {
		System.out.println("eat meat and grass");
	}
}

public class CallTestOverrideEx1 {

	public static void main(String[] args) {
		Sheep mimi = new Sheep();
		mimi.eat();

		Lion king = new Lion();
		king.eat();

		Monkey Goku = new Monkey();
		Goku.eat();

	}

}
