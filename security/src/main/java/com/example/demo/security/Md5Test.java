package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.function.Function;

public class Md5Test {

  private MessageDigest getMD() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

  public String base64UrlEncode(byte[] content) {
    return new String(Base64.getUrlEncoder().encode(content), StandardCharsets.UTF_8);
  }

  public String md5AndBase64(byte[] body) {
    MessageDigest md5 = getMD();
    byte[] digest = md5.digest(body);
    return base64UrlEncode(digest);
  }

  public String directBase64(byte[] body) {
    return base64UrlEncode(body);
  }

  private static RsaCoder rsa;
  private static byte[] oneKBdata = null;
  private static byte[] tenKBdata = null;
  private static byte[] oneMBdata = null;
  private static byte[] tenMBdata = null;

  static {
    initRSA();
    initData();
  }

  private static void initData() {
    //100B
    String body = "qwertyuiopasdfghjkl;zxcvbnm,.1234567890a5tgbnhy67uqwertyuiopasdfghjkl;zxcvbnm,.1234567890a5tgbnhy67u";
    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();
    //1KB
    for (; i < 10; i++) {
      stringBuilder.append(body);
    }
    oneKBdata = stringBuilder.toString().getBytes();
    //10KB
    for (; i < 100; i++) {
      stringBuilder.append(body);
    }
    tenKBdata = stringBuilder.toString().getBytes();
    //1MB
    for (; i < 10000; i++) {
      stringBuilder.append(body);
    }
    oneMBdata = stringBuilder.toString().getBytes();
    //10MB
    for (; i < 100000; i++) {
      stringBuilder.append(body);
    }
    tenMBdata = stringBuilder.toString().getBytes();

  }

  private static void initRSA() {
    try {
      rsa = new RsaCoder();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static byte[] intToByteArray(int a) {
    return new byte[]{
        (byte) ((a >> 24) & 0xFF),
        (byte) ((a >> 16) & 0xFF),
        (byte) ((a >> 8) & 0xFF),
        (byte) (a & 0xFF)
    };
  }

  private static byte[] addBytes(byte[] data1, byte[] data2) {
    byte[] data3 = new byte[data1.length + data2.length];
    System.arraycopy(data1, 0, data3, 0, data1.length);
    System.arraycopy(data2, 0, data3, data1.length, data2.length);
    return data3;

  }


  /**
   *
   * @param testType 测试类型,包含directBase64 或者 md5AndBase64
   * @param executeTime 执行的次数
   * @param fixLengthMessageData 长度固定的数据
   * @throws Exception
   */
  private void test(String testType, int executeTime, byte[] fixLengthMessageData) throws Exception {
    Function<byte[], String> function;
    if ("directBase64".equals(testType)) {
      function = this::directBase64;
    } else if ("md5AndBase64".equals(testType)) {
      function = this::md5AndBase64;
    } else {
      throw new RuntimeException();
    }

    long begin = System.currentTimeMillis();
    String reuslt = "";
    for (int i = 0; i < executeTime; i++) {
      //将计算的次数加入到数据中,使数据是变化的
      byte[] tmpBytes = intToByteArray(i);
      byte[] mergeBytes = addBytes(fixLengthMessageData, tmpBytes);
      String sign = sign(function, mergeBytes);
      reuslt += sign;
    }
    long end = System.currentTimeMillis();
    System.out.println(
        String.format(
            "plan:%s,target lenth:%s,reuslt length:%s,time cost:%s---------------------%s",
            executeTime, fixLengthMessageData.length, reuslt.length(),
            end - begin, testType));
  }

  private String sign(Function<byte[], String> function, byte[] target)
      throws Exception {
    String digest = function.apply(target);
    String strToSign = "POST\n" + digest + "\n" + "11111111111\n" + "www.baidu.com";
    byte[] sign = rsa.signature(strToSign.getBytes(), rsa.getPrivateKey());
    String signatureStr = base64UrlEncode(sign);
    return signatureStr;
  }


  public void signTest() throws Exception {
    String sign = sign(this::directBase64, oneKBdata);
    System.out.println(sign);
  }

  public void md5AndBase64() throws Exception {
    int plan = 1000;
    for (int i = 0; i < 1; i++) {
      System.out.println("-------");
      test("md5AndBase64", plan, oneKBdata);
      test("md5AndBase64", plan, tenKBdata);
      test("md5AndBase64", plan, oneMBdata);
      test("md5AndBase64", plan, tenMBdata);
    }

  }

  public void directBase64() throws Exception {
    int plan = 1000;
    for (int i = 0; i < 1; i++) {
      System.out.println("-------");
      test("directBase64", plan, oneKBdata);
      test("directBase64", plan, tenKBdata);
      test("directBase64", plan, oneMBdata);
      test("directBase64", plan, tenMBdata);
    }

  }


}
