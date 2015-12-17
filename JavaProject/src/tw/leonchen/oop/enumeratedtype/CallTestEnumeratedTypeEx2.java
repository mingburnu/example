package tw.leonchen.oop.enumeratedtype;

public class CallTestEnumeratedTypeEx2 {

	enum Troop {
		stand, jump("john"), sleep, sweep, longwalk;
		private String name = "leon";

		private Troop() {
			System.out.println("over here");
		}

		private Troop(String name) {
           this.name=name;
           System.out.println("name=" + name);
		}
	}

	public static void main(String[] args) {
		Troop[] action = Troop.values();
		for(Troop troop:action){
			System.out.println(troop + ":" + troop.ordinal());
		}
	}

}
