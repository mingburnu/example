package tw.leonchen.oop.nestedclasses;

class Human{
	public void speak(){
		System.out.println("speak language");
	}
}

interface Vehicle{
	public void run();
	public void forward();
	public void backward();
}

public class TestAnonymousNestedClassEx1{

	public static void main(String[] args) {
		new Vehicle(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Car run");
			}

			@Override
			public void forward() {
				// TODO Auto-generated method stub
				System.out.println("Car forward");
			}

			@Override
			public void backward() {
				// TODO Auto-generated method stub
				System.out.println("Car backward");
			}			
		}.forward();
		
		new Human(){
			public void speak(){
				System.out.println("speak chinese");
			}
		}.speak();

	}

}
