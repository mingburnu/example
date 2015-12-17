package tw.leonchen.oop.nestedclasses;

class A{
	String name = "john";
	
	public void execNested(){
		B b1 = new B();
		b1.play();
	}
	
	class B{
		public void play(){
			System.out.println("play with " + name);
		}
	}
}

class C{
	int num=1;
	static int num2=2;
	
	class D{
		public void run(){
			System.out.println("run here");
		}
	}
	
	static class G{
		public void fun(){
			System.out.println("have fun" + num2);
		}
	}
}

class E{
	public void localNested(){
		final int num=6;
		class F{
			public void localplay(){
				System.out.println("play local game " + num);
			}
		}
		
		F f1 = new F();
		f1.localplay();
	}
}

public class CallTestNestedClassesEx1 {

	public static void main(String[] args) {
		A a1 = new A();
		a1.execNested();
		
		C c1 = new C();
		C.D d1 = c1.new D();
		d1.run();
		
		C.G g1 = new C.G();
		g1.fun();
		
		E e1 = new E();
		e1.localNested();
	}

}
