import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

public class byteToBInInt {

  public static void main(String[] args) {
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[16];
    random.nextBytes(key);

    BigInteger bigInteger = new BigInteger(key);
    System.out.println("old:" + Arrays.toString(key));
    System.out.println(bigInteger);
    System.out.println("new:" + Arrays.toString(bigInteger.toByteArray()));

  }

}
