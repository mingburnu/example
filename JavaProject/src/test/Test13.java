package test;

class TestEncapsulationSetAndGet {
	private String name = "mary";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}
}

public class Test13 {
	public static void main(String args[]) {
		TestEncapsulationSetAndGet setandget = new TestEncapsulationSetAndGet();
		setandget.setName("Michael Jordan");
		String theName = setandget.getName();
		System.out.println("theName=" + theName);
	}
}