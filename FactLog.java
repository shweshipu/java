import java.math.log;
import java.math.BigInteger;
public class FactLog {
  public static void main (String a[]){
    long n = Long.valueOf (a[0]);
    System.out.println(n);
    BigInteger factor=new BigInteger("1");
    long i = 0;
    for(i=2;i<=n;i++){
      factor=factor.multiply(BigInteger.valueOf(i));
    }
    BigInteger quotient=new BigInteger("1");
    quotient = quotient.divide(log(factor)/log(n));

    System.out.println(quotient);
  }
}
