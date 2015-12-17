package tw.leonchen.oop.testinterface;

class Animal{
	public void eat(){
		System.out.println("Animal eat food");
	}
}

interface Flyer{
	public void land();
	public void fly();
	public void takeOff();
}

class SuperMan extends Animal implements Flyer{

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("land");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("fly");
	}

	@Override
	public void takeOff() {
		// TODO Auto-generated method stub
		System.out.println("take off");
	}
	
	public void eat(){
		System.out.println("eat human food");
	}
	
	public void stopBullet(){
		System.out.println("stop bullet");
	}
	
}

public class CallTestInterfaceEx1 {

	public static void main(String[] args) {
		SuperMan clark = new SuperMan();
		clark.fly();
		
		Flyer flyer = new SuperMan();
		flyer.land();
	}

}
