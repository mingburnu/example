package test;

class XXX{
	public boolean returnvalue(boolean c){
		
	boolean a=true;
	int b=10;	
	int d=18;
	int e=b*d;
		System.out.println(a);
		System.out.println(e);
		System.out.println(c);
		return c;
		
	}
	
}

public class testboolean {

	public static void main(String[] args) {
		XXX abc=new XXX();
        abc.returnvalue(true);
        
	}

}
