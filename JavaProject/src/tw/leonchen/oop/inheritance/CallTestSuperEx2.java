package tw.leonchen.oop.inheritance;

class Father{
    String my_son_Name;
    Father(String name){
        my_son_Name = name;
    }

    public void getName(){
        System.out.println("My son is "+my_son_Name);
    }
}

public class CallTestSuperEx2 extends Father{
	CallTestSuperEx2(){
        super("Andy");
    }

    public static void main(String[] args) {
    	CallTestSuperEx2 son = new CallTestSuperEx2();
        son.getName();
    }
}