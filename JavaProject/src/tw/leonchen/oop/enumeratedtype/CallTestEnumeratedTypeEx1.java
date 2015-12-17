package tw.leonchen.oop.enumeratedtype;

enum Poker{
	spare(),heart,diamond,club
}

public class CallTestEnumeratedTypeEx1 {

	public static void main(String[] args) {
		Poker suit = Poker.heart;
        switch(suit){
           case spare:
        	   System.out.println(Poker.spare);
        	   break;
           case heart:
        	   System.out.println(Poker.heart);
        	   break;
           case diamond:
        	   System.out.println(Poker.diamond);
        	   break;
           case club:
        	   System.out.println(Poker.club);
        	   break;
        }
	}
}
