package tw.leonchen.oop.method;

class Shirt{
	int price=3000;
	char size = 'S';
}

public class TestReferenceObjectEx1 {

	public static void main(String[] args) {
		Shirt myShirt = new Shirt();
		myShirt.price=1500;
		myShirt.size='M';
		System.out.println("myShirt.price=" + myShirt.price);
		System.out.println("myShirt.size=" + myShirt.size);
	}
}
