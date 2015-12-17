package lab;

public class SquirtFunction {

	public static void main(String[] args) {
		//ax^2+bx+c=0
		double a = -2 , b = 14, c =49;
		double D = (b * b) - (4 * a * c);
		double x1=(-b+ Math.sqrt(D))/(2*a);
		double x2=(-b- Math.sqrt(D))/(2*a);
		double x3=(-b)/(2*a);
		double x4=-c/b;
		System.out.println("D=" + D);
		if (a==0){
			System.out.println("x="+ x4);
		}
		
		else if (D > 0) {
			System.out.println("x1=" + x1);
			System.out.println("x2=" + x2);
					}

		else if (D == 0) {
			System.out.println("x=" + x3);
		}

		
		else{
			System.out.println("virtual squirt");
		}
 
	}

}
