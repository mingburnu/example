package tw.leonchen.oop.testabstract;

abstract class Company{
	public abstract void calculateFuel();
	public abstract void calculateDistance();
	
	public Company(){		
	}
	
	public void payment(){
		System.out.println("pay fee");
	}
}

class Truck extends Company{

	@Override
	public void calculateFuel() {
		System.out.println("Truck calculate Fuel");		
	}

	@Override
	public void calculateDistance() {
		System.out.println("Truck calculate Distance");		
	}	
}

class RiverBarge extends Company{

	@Override
	public void calculateFuel() {
		System.out.println("RiverBarge calculate Fuel");		
	}

	@Override
	public void calculateDistance() {
		System.out.println("RiverBarge calculate Distance");		
	}	
}

public class CallTestAbstractClassEx1 {

	public static void main(String[] args) {
       Company vehicle = new RiverBarge();
       vehicle.calculateFuel();
       vehicle.calculateDistance();
       
       vehicle = new Truck();
       vehicle.calculateFuel();
       vehicle.calculateDistance();
       
       vehicle.payment();
	}

}
