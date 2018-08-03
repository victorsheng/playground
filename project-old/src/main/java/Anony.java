import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anony {





  public void publicMethod() {
    Integer localVariable1 = 10;
    Integer localVariable2 = 10;
    Integer localVariable3 = 10;

    //继承HashMap
    Map<String, Integer> map = new HashMap<String, Integer>() {
      {
        put("a", localVariable1);
        put("b", localVariable2);
        put("c", localVariable3);
      }
    };

    Thread t = new Thread(new Runnable() {
      public void run() {
        System.out.println(localVariable1);
      }
    });

    Thread t2 = new Thread(() -> {
      System.out.println(localVariable1);
    });

    List<String> list = Arrays.asList("A", "B", "C");
    Collections.sort(list, new Comparator<String>() {
      public int compare(String p1, String p2) {
        return p1.compareTo(p2);
      }
    });

    List<String> list2 = Arrays.asList("A", "B", "C");
    Collections.sort(list, (p1, p2) -> {
      return p1.compareTo(p2);
    });
  }

  public static void hello() {
    int i = 0;
    i++;
  }
}

