package homonorphic;

import java.math.BigInteger;
import java.util.Random;

public class Homomorphic {


  public RsaModel getRsaKey() {
    // ===========================
// 先演示密钥对生成过程
// ===========================
// 定义位长
    final int bitLen = 2048;
// 随机源
    final Random ran = new Random();
// 第一步，随机生成两个不相等的质数p和q。
    BigInteger p = BigInteger.probablePrime(bitLen / 2, ran);
    BigInteger q = BigInteger.probablePrime(bitLen / 2, ran);
// 第二步，计算p和q的乘积n。
// n的长度就是密钥长度。实际应用中，RSA密钥一般是1024位，重要场合则为2048位。
    BigInteger n = p.multiply(q);
// 第三步，计算n的欧拉函数φ(n)。
    BigInteger zn = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
// 第四步，随机选择一个整数e，条件是1< e < φ(n)，且e与φ(n) 互质。实际应用中，常常固定选择65537
    BigInteger e = new BigInteger("65537");
// 第五步，计算e对于φ(n)的模反元素d。
// 所谓"模反元素"就是指有一个整数d，可以使得ed被φ(n)除的余数为1。
// ed ≡ 1 (mod φ(n))
    BigInteger d = e.modInverse(zn);
// 我们输出一下最后得到的3个数
//    System.out.println("N:" + n);
//    System.out.println("E:" + e);
//    System.out.println("D:" + d);
// 第六步，将n和e封装成公钥，n和d封装成私钥。
// 实际应用中，公钥和私钥的数据都采用ASN.1格式表达,这里不演示。

// ===========================
// 再演示加解密过程
// ===========================
// 加密
//    BigInteger v = new BigInteger("123456789123456789");
//    System.out.println("源数据:" + v);
//    v = v.modPow(e, n);//用公钥加密
//    System.out.println("加密后:" + v);
//// 解密
//    v = v.modPow(d, n);//用私钥解密
//    System.out.println("解密后:" + v);

    return new RsaModel(n, d, e);
  }

  public static void main(String[] args) {
    Homomorphic homomorphic = new Homomorphic();
    RsaModel rsaKey = homomorphic.getRsaKey();
    System.out.println(rsaKey);

    BigInteger a = new BigInteger("123456789123456789");
    BigInteger b = new BigInteger("23");
    BigInteger ea = a.modPow(rsaKey.getE(), rsaKey.getN());//用公钥加密
    BigInteger eb = b.modPow(rsaKey.getE(), rsaKey.getN());//用公钥加密
    BigInteger abMultiplyResult = a.multiply(b);
    BigInteger eab = ea.multiply(eb);

    BigInteger message = eab.modPow(rsaKey.getD(), rsaKey.getN());
    System.out.println(abMultiplyResult);
    System.out.println(message);


  }
}
