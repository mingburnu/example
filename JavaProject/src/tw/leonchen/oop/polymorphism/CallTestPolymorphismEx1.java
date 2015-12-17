package tw.leonchen.oop.polymorphism;

class Mammal {
	public static void hit(Mammal m) { // Mammal m = lucky; Mammal m = new
										// Dog();
		m.cry(); // Mammal m = new Cat();
	}

	public void cry() {
		System.out.println("Mammal cry");
	}
}

class Dog extends Mammal {
	public void cry() {
		System.out.println("Wong Wong !!");
	}

	public void play() {
		System.out.println("play");
	}
}

class Cat extends Mammal {
	public void cry() {
		System.out.println("Mouw MOuw !!");
	}

	public void jumpAway() {
		System.out.println("Cat Jump Away !!");
	}
}

public class CallTestPolymorphismEx1 {

	public static void main(String[] args) {
		Dog lucky = new Dog();
		Mammal.hit(lucky);
		Mammal.hit(new Cat());
		/*
		 * Mammal lucky= new Cat(); Dog d = new Dog(); lucky =(Dog) d;
		 * lucky.cry();
		 */
		// Casting

	}
}
