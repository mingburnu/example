package Lab01;

public class PrimeNumber
{
  // This method tests whether a given number is prime or not.
  public static boolean isPrime ( int num )
  {
    boolean prime = true;
    int limit = (int) Math.sqrt ( num );  

    for ( int i = 2; i <= limit; i++ )
    {
      if ( num % i == 0 )
      {
        prime = false;
	break;
      }
    }

    return prime;
  }

  public static void main ( String[] args )
  {
    // This loop writes out all the prime numbers less than 1000.
    for ( int i = 2; i <= 30; i++ )
    {
      if ( isPrime ( i ) ){
	System.out.println ( i );}
    }
  }
}