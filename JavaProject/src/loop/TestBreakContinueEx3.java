package loop;
public class TestBreakContinueEx3
{
  public static void main(String args[])
  {
  	int i=1;
    while(i<=100)
    {
      if(i==51)
      {
      	//System.out.println("i2=" + i);
        continue;	
      }	
      System.out.println("i1=" + i);
      i++;
    }
    System.out.println("finished");
  }
}