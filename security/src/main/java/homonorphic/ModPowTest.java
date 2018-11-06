package homonorphic;

import java.math.BigInteger;

public class ModPowTest {

  public static void main(String[] args) {
    BigInteger integer = BigInteger.valueOf(65l);
    BigInteger integer1 = integer.modPow(BigInteger.valueOf(17), BigInteger.valueOf(3233));
    System.out.println(integer1);

  }

}
