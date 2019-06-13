package cn.victor123.randomfs;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

  public static void main(String[] args) throws Exception {
    int length = args.length;
    long s = System.currentTimeMillis();
    for (int i = 0; i < length; ++i) {
      BufferedReader br = new BufferedReader(new FileReader(args[i]));
      String line = "";
      while ((line = br.readLine()) != null) {

      }
      br.close();
    }
    System.out.println(System.currentTimeMillis() - s);

  }
}
