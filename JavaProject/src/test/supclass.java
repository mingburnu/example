package test;

class Animal {
	int aMask = 0x00FF;

	public Animal() {
	}

	public Animal(int mask) {
		aMask = mask;
	}
}

public class supclass extends Animal {
	int bMask = 0xFF00;
	int fullMask;

	public supclass() {
		// Compiler add super() here
		fullMask = bMask | aMask;
	}

	public supclass(int mask) {
		/* �Y��super,�h������b�Ĥ@��,�s�ܼƫŧi�]�����\�bsuper�e�� */
		super(mask);
		fullMask = bMask | aMask;
	}

	public static void main(String[] argv) {
		supclass b = new supclass();
		System.out.println(b.fullMask);
		b = new supclass(0x0011);
		System.out.println(b.fullMask);
	}
}
