package com.example.demo.charset;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.junit.Test;

public class Test1 {

  public static void main(String[] args) throws UnsupportedEncodingException {
    char data[] = {0x41, 0x42, 0x43};
    System.out.println(new String(data));

    byte[] gbkBytes = {(byte) 0xD6, (byte) 0xD0, (byte) 0xB9, (byte) 0xFA};
    System.out.println(new String(gbkBytes, "GBK"));

    byte[] unicodeBytes = {(byte) 0x4E, (byte) 0x2D, (byte) 0x56, (byte) 0xFD};
    System.out.println(new String(gbkBytes, "Unicode"));
  }

  @Test
  public void chinese() {
    String str = "中国";
    printBytes(str);
  }

  @Test
  public void email() {
    String str = "aa@qq.com";
    printBytes(str);
  }

  private void printBytes(String str) {
    printBytes(str + "的UNICODE编码：", str.getBytes(Charset.forName("unicode")));
    printBytes(str + "的8859编码：", str.getBytes(Charset.forName("ISO-8859-1")));
    printBytes(str + "的BIG5编码：", str.getBytes(Charset.forName("BIG5")));
    printBytes(str + "的GBK编码：", str.getBytes(Charset.forName("GBK")));
    printBytes(str + "的UTF-8编码：", str.getBytes(Charset.forName("UTF-8")));
  }

  public void printBytes(String title, byte[] data) {
    System.out.println(title);
    for (byte b : data) {
      System.out.print("0x" + toHexString(b) + " ");
    }
    System.out.println();
  }

  public String toHexString(byte value) {
    String tmp = Integer.toHexString(value & 0xFF);
    if (tmp.length() == 1) {
      tmp = "0" + tmp;
    }

    return tmp.toUpperCase();
  }

  @Test
  public void print() {
    byte[] unicodeBytes = {(byte) 0x4E, (byte) 0x2D, (byte) 0x56, (byte) 0xFD};
    System.out.println(new String(unicodeBytes, Charset.forName("unicode")));

    byte[] gbkBytes = {(byte) 0xD6, (byte) 0xD0, (byte) 0xB9, (byte) 0xFA};
    System.out.println(new String(gbkBytes, Charset.forName("GBK")));

    byte[] utf8Bytes = {(byte) 0xE4, (byte) 0xB8, (byte) 0xAD, (byte) 0xE5, (byte) 0x9B,
        (byte) 0xBD};
    System.out.println(new String(utf8Bytes, Charset.forName("UTF-8")));
  }
}
