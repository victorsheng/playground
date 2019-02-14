package diffchar;

import java.io.UnsupportedEncodingException;

public class PrintDif {

  public static void encode() throws UnsupportedEncodingException {
    String name = "中国";
    System.out.println("char default");
    toHex(name.toCharArray());

    System.out.println("ISO-8859-1");
    byte[] iso8859 = name.getBytes("ISO-8859-1");
    toHex(iso8859);

    System.out.println("GB2312");
    byte[] gb2312 = name.getBytes("GB2312");
    toHex(gb2312);

    System.out.println("GBK");
    byte[] gbk = name.getBytes("GBK");
    toHex(gbk);

    System.out.println("UTF-16");
    byte[] utf16 = name.getBytes("UTF-16");
    toHex(utf16);

    System.out.println("UTF-8");
    byte[] utf8 = name.getBytes("UTF-8");
    toHex(utf8);
  }

  private static void toHex(char[] chars) {
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i] + "/");
    }
    System.out.println();
  }

  private static void toHex(byte[] chars) {
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i] + "/");
    }
    System.out.println();
  }

  public static void main(String[] args) throws UnsupportedEncodingException {
    encode();
  }

}
