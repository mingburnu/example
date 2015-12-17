package loop;
public class TestBreakContinueEx2
{
  public static void main(String args[])
  {
    for(int i=1;i<=100;i++)
    {
      if(i==51)
      {
        continue;	
      }	
      System.out.println("i=" + i);
    }
    System.out.println("finished");
  }
}