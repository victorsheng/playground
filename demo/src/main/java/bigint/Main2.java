package bigint;

import java.math.BigInteger;

public class Main2 {

  public static void main(String[] args) {
    BigInteger integer = new BigInteger(
        "8780710799663312522437781984754049815806883199414208211028653399266475630880222957078625179422662221423155858769582317459277713367317481324925129998224791");
    System.out.println(integer.bitLength());
    System.out.println(integer.bitCount());
  }

}
