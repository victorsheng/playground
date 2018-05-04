package com.example.demo.string;

import java.util.function.Supplier;
import org.junit.Test;

public class AppendTest2 {

  public static final String WOSHISUANFA = "woshisuanfa";
  public static final String B446E731146E796C35FB82E156924 = "027b446e731146e796c35fb82e156924";


  public void tongJi(Supplier supplier) {
    long nanoTime = System.nanoTime();
    supplier.get();
    System.out.println(System.nanoTime() - nanoTime);
  }

  public String appendStr() {
    String inputFileName = "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa"
        + "aaaaaaaa";
    System.out.println(inputFileName);
    return inputFileName;
  }

  public String stringBuilder() {
    String inputFileName = new StringBuilder("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa")
        .append("aaaaaaaa").toString();
    System.out.println(inputFileName);
    return inputFileName;
  }

  @Test
  public void test1() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::appendStr);
  }

  @Test
  public void test2() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::appendStr);
  }

  @Test
  public void test3() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::appendStr);
  }


  @Test
  public void test4() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::stringBuilder);
  }

  @Test
  public void test5() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::stringBuilder);
  }

  @Test
  public void test6() {
    AppendTest2 appendTest2 = new AppendTest2();
    tongJi(appendTest2::stringBuilder);
  }
}
