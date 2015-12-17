package loop;
public class TestDiceEx1
{
  public static void main(String args[])
  {
    int myLuckyNumber = 6;    
    
    while(true)
    {
      int rNum = (int)(Math.random()*6)+1;
      System.out.println("rNum=" + rNum); 
      
      if(myLuckyNumber==rNum)
      {
    	  System.out.println("you win");
    	  break;
      }
      else
      {
    	  System.out.println("you lose");
      }
    }    
  }
}  