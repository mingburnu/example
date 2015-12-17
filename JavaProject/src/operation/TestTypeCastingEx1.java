package operation;
public class TestTypeCastingEx1
{
  public static void main(String args[])
  {
    byte b1=2,b2=127,b3;
    b3=(byte)(b1+b2);
    System.out.println("b1=" + b1);
    System.out.println("b2=" + b2);
    System.out.println("b3=" + b3);
  }
}