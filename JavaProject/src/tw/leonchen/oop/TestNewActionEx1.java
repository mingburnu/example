package tw.leonchen.oop;

class Shirt{
	int price=2000;
	char size='L';
}

public class TestNewActionEx1 {

	public static void main(String[] args) {
		Shirt myShirt = new Shirt();
		Shirt yourShirt = new Shirt();
		
		myShirt.price=1500;
		myShirt.size='S';
		
		yourShirt.price=3000;
		yourShirt.size='M';
		
		System.out.println("myShirt.price=" + myShirt.price);
		System.out.println("myShirt.size=" + myShirt.size);
		
		System.out.println("yourShirt.price=" + yourShirt.price);
		System.out.println("yourShirt.size=" + yourShirt.size);
		
		System.out.println("myShirt=" + myShirt);
		System.out.println("yourShirt=" + yourShirt);
		
		myShirt=yourShirt;
		
		yourShirt.price=5000;
		yourShirt.size='X';
		
		System.out.println("myShirt.price_1=" + myShirt.price);
		System.out.println("myShirt.size_1=" + myShirt.size);
		
		System.out.println("myShirt_1=" + myShirt);
		System.out.println("yourShirt_1=" + yourShirt);

	}

}
