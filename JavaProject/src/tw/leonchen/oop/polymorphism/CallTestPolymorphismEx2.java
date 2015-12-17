package tw.leonchen.oop.polymorphism;

class Animal {
	public String moveMethod() {
		return "Unspecified";
	}
}

class Bird extends Animal {
	public String moveMethod() {
		return "Fly";
	}
}

class Deer extends Animal {
	public String moveMethod() {
		return "run";
	}
}

class Fish extends Animal {
	public String moveMethod() {
		return "swim";
	}
}

public class CallTestPolymorphismEx2 {

	public static void main(String[] args) {
		Animal a = new Bird(); // upcasting
		// b = (Bird)a; // downcasting, compile correct
		if (a instanceof Bird) { // true
			System.out.println(a.moveMethod());
		}
	}
}
