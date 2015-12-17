package loop;
public class TestDiceEx2
{
  public static void main(String args[])
  {
    int myLuckyNumber = 6;    
    int count=0;
    while(true)
    {
      int rNum = (int)(Math.random()*6)+1;
      System.out.println("rNum=" + rNum); 
      
      if(myLuckyNumber==rNum)
      {
      	count++;
    	  if(count==1)
    	  {
    	  	System.out.println("you win");
    	    break;
    	  }    	  
      }
      else
      {
    	  System.out.println("you lose");
      }
    }    
  }
}