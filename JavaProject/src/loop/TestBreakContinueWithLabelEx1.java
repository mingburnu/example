package loop;
public class TestBreakContinueWithLabelEx1
{
  public static void main(String args[])
  {
    test:
    for(int i=1;i<=10;i++)
    {
      for(int j=1;j<=10;j++)
      {
        if(i==2 && j==3)
        {
          //break;
          //continue;
          //break test;
          continue test;	
        }
        System.out.println("i=" + i + " j=" + j);	
      }	
    }
  }
}