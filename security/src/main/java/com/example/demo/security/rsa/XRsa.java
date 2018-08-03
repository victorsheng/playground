package com.example.demo.security.rsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class XRsa {

  public static final String CHARSET = "UTF-8";
  public static final String RSA_ALGORITHM = "RSA";
  public static final String RSA_ALGORITHM_SIGN = "SHA256WithRSA";

  private RSAPublicKey publicKey;
  private RSAPrivateKey privateKey;

  public XRsa(String publicKey, String privateKey) {
    try {
      KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);

      //通过X509编码的Key指令获得公钥对象
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(
          Base64.getDecoder().decode(publicKey));
      this.publicKey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
      //通过PKCS#8编码的Key指令获得私钥对象
      PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(
          Base64.getDecoder().decode(privateKey));
      this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
    } catch (Exception e) {
      throw new RuntimeException("不支持的密钥", e);
    }
  }

  public static Map<String, String> createKeys(int keySize) {
    //为RSA算法创建一个KeyPairGenerator对象
    KeyPairGenerator kpg;
    try {
      kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
    }

    //初始化KeyPairGenerator对象,不要被initialize()源码表面上欺骗,其实这里声明的size是生效的
    kpg.initialize(keySize);
    //生成密匙对
    KeyPair keyPair = kpg.generateKeyPair();
    //得到公钥
    Key publicKey = keyPair.getPublic();
    String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
    //得到私钥
    Key privateKey = keyPair.getPrivate();
    String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
    Map<String, String> keyPairMap = new HashMap<String, String>();
    keyPairMap.put("publicKey", publicKeyStr);
    keyPairMap.put("privateKey", privateKeyStr);

    return keyPairMap;
  }

  public String publicEncrypt(String data) {
    try {
      Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      return Base64.getEncoder().encodeToString(
          rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET),
              publicKey.getModulus().bitLength()));
    } catch (Exception e) {
      throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
    }
  }

  public String privateDecrypt(String data) {
    try {
      Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.getDecoder().decode(data),
          publicKey.getModulus().bitLength()), CHARSET);
    } catch (Exception e) {
      throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
    }
  }

  public String privateEncrypt(String data) {
    try {
      Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, privateKey);
      return Base64.getEncoder().encodeToString(
          rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET),
              publicKey.getModulus().bitLength()));
    } catch (Exception e) {
      throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
    }
  }

  public String publicDecrypt(String data) {
    try {
      Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, publicKey);
      return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.getDecoder().decode(data),
          publicKey.getModulus().bitLength()), CHARSET);
    } catch (Exception e) {
      throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
    }
  }

  public String sign(String data) {
    try {
      //sign
      Signature signature = Signature.getInstance(RSA_ALGORITHM_SIGN);
      signature.initSign(privateKey);
      signature.update(data.getBytes(CHARSET));
      return Base64.getEncoder().encodeToString(signature.sign());
    } catch (Exception e) {
      throw new RuntimeException("签名字符串[" + data + "]时遇到异常", e);
    }
  }

  public boolean verify(String data, String sign) {
    try {
      Signature signature = Signature.getInstance(RSA_ALGORITHM_SIGN);
      signature.initVerify(publicKey);
      signature.update(data.getBytes(CHARSET));
      return signature.verify(Base64.getDecoder().decode(sign));
    } catch (Exception e) {
      throw new RuntimeException("验签字符串[" + data + "]时遇到异常", e);
    }
  }

  private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
    int maxBlock = 0;
    if (opmode == Cipher.DECRYPT_MODE) {
      maxBlock = keySize / 8;
    } else {
      maxBlock = keySize / 8 - 11;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] buff;
    int i = 0;
    try {
      while (datas.length > offSet) {
        if (datas.length - offSet > maxBlock) {
          buff = cipher.doFinal(datas, offSet, maxBlock);
        } else {
          buff = cipher.doFinal(datas, offSet, datas.length - offSet);
        }
        out.write(buff, 0, buff.length);
        i++;
        offSet = i * maxBlock;
      }
    } catch (Exception e) {
      throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
    }
    byte[] resultDatas = out.toByteArray();
    try {
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return resultDatas;
  }

  public static void main(String[] args) throws Exception {
    XRsa xRsa = new XRsa(
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChsKXVjDAfOvH3qgGmxtmiK8/qo1uZ0l+NMofQu9eAPuLIWzRxzNYzoOwB+Kr/aZgCKndGKHDNrIfpCHJWRHzmpQdcXtEmgKW7QU2KY9XkDy57Gy78kk5kxsf2t1RBv4DHI45374DSp6sqFrzM7bJpDgk5rXvg5bSmqD4Mysd82wIDAQAB",
        "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKGwpdWMMB868feqAabG2aIrz+qjW5nSX40yh9C714A+4shbNHHM1jOg7AH4qv9pmAIqd0YocM2sh+kIclZEfOalB1xe0SaApbtBTYpj1eQPLnsbLvySTmTGx/a3VEG/gMcjjnfvgNKnqyoWvMztsmkOCTmte+DltKaoPgzKx3zbAgMBAAECgYEAhthLdUz01RbTtTiTKAOufREM1SJnwmEwTxFVMz90+f94Ip/tnPq3qVcLfJlmApyNqUDBOEGB0gWRU0c4E7oKbvtasrikm6VaQL6b1bJWMKBGoDbCpABhc/JPDI1leYeVNemYlRSO17c0Zh29Auh/PxGsX5PYFugt4p8OzdN4dAECQQDfco6YbPBy8DI5nDkeT/ygCosDwH5uh/jJedIoyKA5MHJcrJyFbbYHhFPaghgXH105jQ6FvWRkTIB9aD/HKaF/AkEAuT7a38MkUhpgvrc3uaBrYDFszmzeWbUXEC0shGs5S32bhvbYzgc2rUjfcWxQimx9qWpAcAbUVesYngN0bDSapQJBAJcbwZMTGQihp1WOcJIvRYh1mM1QwC+/hF+8IoOyKaiDOtOxZ6hUKWWr94ktsVzxuPnSip+nFN0/XyVv+rGVVcECQAc4FduGhVHVyVNlXHyVbdnP00ewInIohn+Q4x09+Huip374+7X7vfu+zUZkTDc4xyTlCSHUgk3e3ZS62bylyCkCQAi5Udx564+uESwhgMA5W7kXmyTXVllfbxsOeD3+jkrV4QvdUlmqpHzTWi5O/v0ACeINWHA0uwuR9t9ujUbqrHo=");
    String smple = "2345678i9olkmjnbvfrtyujkmnbvfgtyhujkjmnb2345678i9o2345678i92345672345678i9olkmjnbvfrtyujkmnbvfgtyhujkjmnbvghyjunbghjumn8i9olkmjnbvfrtyujkmnbvfgtyhujkjmnbvghyjunbghjumnolkmjnbvfrtyujkmnbvfgtyhujkjmnbvghyjunbghjumnlkmjnbvfrtyujkmnbvfgtyhujkjmnbvghyjunbghjumnvghyjunbghjumn";
    String middle = xRsa.publicEncrypt(smple);
    String revert = xRsa.privateDecrypt(middle);

    System.out.println(smple);
    System.out.println(revert);

    System.out.println(xRsa.publicKey.getModulus().bitLength() / 8);
    System.out.println(xRsa.privateKey.getModulus().bitLength() / 8);
  }
}
