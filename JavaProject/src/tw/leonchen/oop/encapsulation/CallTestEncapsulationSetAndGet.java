package tw.leonchen.oop.encapsulation;

class TestEncapsulationSetAndGet{ 
    private String name = "mary";
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
   }
} 

public class CallTestEncapsulationSetAndGet{ 
    public static void main(String args[]){
        TestEncapsulationSetAndGet  setandget = new TestEncapsulationSetAndGet();
        setandget.setName("Michael Jordan");
        String theName = setandget.getName();
        System.out.println("theName=" + theName );
    }
}
