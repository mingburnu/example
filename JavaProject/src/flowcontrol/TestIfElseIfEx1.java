package flowcontrol;
public class TestIfElseIfEx1
{
  public static void main(String args[])
  {
    int month=15;
    
    if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
    {
      System.out.println(month + " has 31 days");	
    }
    else if(month==4 || month==6 || month==9 || month==11)
    {
      System.out.println(month + " has 30 days");	
    }
    else if(month==2)
    {
      System.out.println(month + " has 28 days");		
    }
    else
    {
      System.out.println("Invalid month");	
    }
    System.out.println("finished");
  }
}  