package test;

class C {
	int num = 1;
	static int num2 = 2;

	class D {
		public void run() {
			System.out.println("have fun" + num);
		}

		class G {

			public void fun() {
				System.out.println("have fun" + num2);
			}

		}

	}
}

public class test14 {

	public static void main(String[] args) {

		C c1 = new C();
		C.D d1 = c1.new D();

		d1.run();
		C c2 = new C();

		C.D d2 = c2.new D();

		C.D.G g1 = d2.new G();

		// g1.fun();

	}

}
