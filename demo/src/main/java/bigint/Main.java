package bigint;

import java.math.BigInteger;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    BigInteger integer = BigInteger.probablePrime(1024, new Random());
    String str = integer.toString();
    System.out.println("biginteger:" + integer);
    System.out.println("bitLength:" + integer.bitLength());
    System.out.println("bitCount:" + integer.bitCount());
    System.out.println("str.length:" + str.length());
  }

}
