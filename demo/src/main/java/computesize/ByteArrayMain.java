package computesize;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.util.VMSupport;

public class ByteArrayMain {

  public static void main(String[] args) {
    System.out.println(VMSupport.vmDetails());

    byte[] bytes = new byte[10];
    for (int i = 0; i < 10; i++) {
      bytes[i] = (byte) i;
      System.out.println(GraphLayout.parseInstance(bytes).toPrintable());
      System.out.println("------------");
    }
  }

}
