package computesize;

import java.util.HashMap;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.util.VMSupport;

public class JoLMain {

  public static void main(String[] args) {
    System.out.println(VMSupport.vmDetails());
    System.out.println(ClassLayout.parseClass(Integer.class).toPrintable());
    HashMap<Object, Object> map = new HashMap<>();
    map.put("1", "1");
    System.out.println(GraphLayout.parseInstance(map).toPrintable());
  }

}
