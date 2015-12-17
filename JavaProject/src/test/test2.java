package test;

public class test2 {
int x=2, y=3;
	
	public void function(int x, int y){
		this.x=1;
		this.y=2;
	}
	
	public static void main(String[] args) {
		test2 t1 = new test2();
		t1.function(7, 5);
		System.out.println("test1.x=" + t1.x);
		System.out.println("test1.y=" + t1.y);
		System.out.println("finished");
	}

	

}
