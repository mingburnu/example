package flowcontrol;
public class TestIfElseEx1
{
  public static void main(String args[])
  {
    int diceNumber=(int)(Math.random()*6)+1;
    int myLuckynumber=(int)(Math.random()*6)+1;;
    
    System.out.println("diceNumber=" + diceNumber);	
    System.out.println("myLuckynumber=" + myLuckynumber);
    
    if(myLuckynumber>diceNumber)
    {
      System.out.println("you win !!");	
    }
    else
    {
    	System.out.println("you lose !!");
    }  
    System.out.println("finished"); 
  }
}  