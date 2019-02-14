package diffchar;

import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TestCharset {

  /**
   * 什么是编码,来说说编码的由来？ 1    最早 我们以ISO-8859-1来编码：ISO-8859比较早的编码集合，它只能够编码0-255个英文或符号或数字.
   * 可以打开网页http://wenku.baidu.com/view/758a176a1eb91a37f1115ccb.html  查看255个 英文或符号或数字用一个ASCII值对应
   * ASCII值(key) = char(value)    value为英文或符号或数字 49   =   1            1 为一个char char------>key 编码
   * key ------>char 解码
   *
   * 在JAVA 中char  int  byte 是可以相互转化的 且转化规则同ISO-8859-1 且byte直接通过int来显示   也就是说     (char)byte 相当于解码了！
   *
   * 63   63   49  50  51  00 中      文  1    2   3  \0
   *
   * 对于字符数字可以对应， 对于中文无法识别的则编码为63 显示为 ?
   *
   * 2   后来由于英文不能编码其他各国语言出现了各种本地编码（本地编码都是兼容ISO-8859-1,且相互兼容）的 如解析中文的GBK,GB2312，GBK编码是不定长编码,对于中文使用2字节，英文解析同ISO-8859-1
   * D6 D0  CE C4   49  50  51  00 中        文     1   2   3  \0
   *
   * 对于中文2字字节， 对于英文则解析同ISO-8859-1，达到兼容
   *
   * D6 D0 为key    中为值, 当打印byte 时只能打印出数字，无法打印出D6 D0，想要打印出key 需要用URLEncoder.encode(cn, "GBK") 去掉前面的%
   *
   *
   * 3   在后来出现了unicode，这是最统一的编码，可以用来表示所有语言的字符，而且是定长双字节（也有四字节的）编码，包括英文字母在内。所以可以说它是不兼容iso8859-1编码的，也不兼容任何编码。不过，相对于
   * iso8859-1编码来说，uniocode编码只是在前面增加了一个0字节，比如字母A为"00 61" 代表为utf-16
   *
   * 2D   4E  87  65  31  00  32  00  33  00  00  00       ← 在 x86 CPU 中，低字节在前 中            文 1
   * 2       3      \0
   *
   * 对于中文,英文都是2字字节， 不兼容ISO-8859-1
   *
   * 2D    4E 为key    中为值, 当打印byte 时只能打印出数字，无法打印出2D    4E，想要打印出key 需要用URLEncoder.encode(cn,
   * "utf-16") 去掉前面的%
   *
   * 4   最后考虑到unicode编码不兼容iso8859-1编码，而且容易占用更多的空间：因为对于英文字母，unicode也需要两个字节来表示。所以unicode不便于传输和存储。因此而产生了utf编码，utf
   * 编码兼容iso8859-1编码，同时也可以用来表示所有语言的字符，不过，utf编码是不定长编码，每一个字符的长度从1-6个字节不等。另外，utf编码自带简单的校验功能。一般来讲，英文字母都是用
   * 一个字节表示，而汉字使用三个字节
   *
   * E4   B8   AD    -26 -106 -121  49  50  51 中                       文              1      2   3
   *
   * 对于中文3字字节， 对于英文则解析同ISO-8859-1，达到兼容
   *
   * E4   B8   AD 为key    中为值, 当打印byte 时只能打印出数字，无法打印出2D    4E，想要打印出key 需要用URLEncoder.encode(cn,
   * "utf-8") 去掉前面的%
   *
   * 在JAVA中String是使用unicode进行编码(unicode 的目标就是能支持世界上所有的字符集，也就是说几乎所有的字符集包含的字符在unicode中都有对应的编码)
   *
   * String的getBytes(charset)方法就是对特定的字符串按照给定的字符集进行编码（encode） 即 (String --> XXX字符集编码为一个byte[] bytes)
   * String的new String(byte[],charset)则可以按照某个字符集将字节流转换回（decode)   即(byte[] bytes -->
   * XXX字符集解码后转化为String)
   *
   * 如果想知道对应key 则可以通过   URLEncoder.encode(s) URLDecoder.decode(s)
   */
  public static void testCharset() throws Exception {

    String strEnString = "ABC123";
    String strChineseString = "中文123";
    System.out.println("不同字符集的编码:");

    System.out.println("==========ISO-8859-1===============");
    byte[] iso8859 = strEnString.getBytes(Charset.forName("ISO-8859-1"));
    byte[] iso88592 = strChineseString.getBytes(Charset.forName("ISO-8859-1"));

    /**
     * 打印出iso8859的编码byte,java中byte使用int打印，而java 中int byte char的规则同iso8859一致，所以直接打印出了ASCII值 且如果 (char)iso8859[i]
     * 相当于解码
     **/
    for (int i = 0; i < iso8859.length; i++) {
      System.out.print(iso8859[i] + "/");
    }
    System.out.println();

    for (int i = 0; i < iso88592.length; i++) {
      System.out.print(iso88592[i] + "/");
    }
    System.out.println();

    System.out.println("============gbk==================");
    byte[] gbk = strChineseString.getBytes(Charset.forName("gbk"));
    /** 打印出gbk 编码的byte 对应转化的数字 **/
    for (int i = 0; i < gbk.length; i++) {
      System.out.print(gbk[i] + "/");
    }
    System.out.println();
    /** 打印出gbk 编码的 key **/
    System.out.println(URLEncoder.encode(strChineseString, "gbk"));

    System.out.println("=============utf-16==============");
    byte[] utf16 = strChineseString.getBytes(Charset.forName("utf-16"));
    for (int i = 0; i < utf16.length; i++) {
      System.out.print(utf16[i] + "/");
    }
    System.out.println();
    /** 打印出gbk 编码的 utf-16 **/
    System.out.println(URLEncoder.encode(strChineseString, "utf-16"));

    System.out.println("=============utf-8===============");
    byte[] utf8 = strChineseString.getBytes(Charset.forName("utf-8"));
    for (int i = 0; i < utf8.length; i++) {
      System.out.print(utf8[i] + "/");
    }
    System.out.println();
    /** 打印出gbk 编码的 utf-8 **/
    System.out.println(URLEncoder.encode(strChineseString, "utf-8"));

    System.out.println("=============byte[],char[]相互转化 ===============");
    ByteBuffer iso8859Byte = Charset.forName("ISO-8859-1").encode(strChineseString);
    CharBuffer iso8859Char = Charset.forName("ISO-8859-1").decode(iso8859Byte);

    System.out.println("=============JAVA 英文 ISO-8859-1编码和 其他编码解码 ===============");
    String en = "ABD221213";
    /** 当时英文和数字的时候,其他编码兼容ISO-8859-1（以ISO-8859-1 方式解析为byte) 编码解码没有问题 **/
    iso8859 = en.getBytes(Charset.forName("ISO-8859-1"));
    System.out.println(new String(iso8859, Charset.forName("ISO-8859-1")));
    System.out.println(new String(iso8859, Charset.forName("gbk")));
    System.out.println(new String(iso8859, Charset.forName("utf-8")));

    System.out.println("=============JAVA 中文 ISO-8859-1编码和其他编码解码 ===============");
    String cn = "中文123";
    /** 当出现中文时，ISO-8859-1找不到对应的，则当做63 即? 来编码 **/
    iso8859 = cn.getBytes(Charset.forName("ISO-8859-1"));
    /** 其他的编码按照 ISO-8859-1 来解码 为 ??123 **/
    System.out.println(new String(iso8859, Charset.forName("ISO-8859-1")));
    System.out.println(new String(iso8859, Charset.forName("gbk")));
    System.out.println(new String(iso8859, Charset.forName("utf-8")));

    System.out.println("=============JAVA 中文 utf-8编码和其他编码解码 ===============");
    cn = "中文123";
    /** 当出现中文时，utf-8 编码为3个字节， 英文同ISO-8859-1 **/
    utf8 = cn.getBytes(Charset.forName("utf-8"));
    /** ISO-8859-1找不到 utf-8 对‘中文’编码的字节，无法解码失败为 ä¸­æ **/
    System.out.println(new String(utf8, Charset.forName("ISO-8859-1")));
    /** gbk找不到 utf-8 对‘中文’编码的字节，无法解码失败为涓枃 **/
    System.out.println(new String(utf8, Charset.forName("gbk")));
    System.out.println(new String(utf8, Charset.forName("utf-8")));

    System.out.println("=============JAVA 中文 gbk编码和其他编码解码 ===============");
    cn = "中文123";
    /** 当出现中文时，utf-8 编码为3个字节， 英文同ISO-8859-1 **/
    gbk = cn.getBytes(Charset.forName("gbk"));
    /** ISO-8859-1找不到 gbk 对‘中文’编码的字节，无法解码失败为 ÖÐÎÄ **/
    System.out.println(new String(gbk, Charset.forName("ISO-8859-1")));
    /** utf-8 找不到 gbk 对‘中文’编码的字节，无法解码失败为 ���� **/
    System.out.println(new String(gbk, Charset.forName("utf-8")));
    System.out.println(new String(gbk, Charset.forName("gbk")));

    System.out.println("=============乱码的解决办法 ===============");
    /** 当出现中文时使用gbk编码错误的时候ISO-8859-1解码 **/
    String testerror = new String(strChineseString.getBytes("gbk"), Charset.forName("ISO-8859-1"));
    System.out.println(testerror);
    /** 1 testerror.getBytes("ISO-8859-1") 对错误的字符使用ISO-8859-1编码 */
    /** 2 new String(testerror.getBytes("ISO-8859-1"),Charset.forName("gbk"));对编码后的字节在gbk解码 */
    String testxiugai = new String(testerror.getBytes("ISO-8859-1"), Charset.forName("gbk"));
    System.out.println(testxiugai);

    System.out.println("=============JAVA 中文 URLEncoder.encode重复编码 ===============");
    cn = "中文";
    /** 中文答应出 %E4%B8%AD%E6%96%87 **/
    System.out.println(URLEncoder.encode(cn, "UTF-8"));
    /** %25E4%25B8%25AD%25E6%2596%2587 继续编码值是把% 编码为25 又在前面加上了% **/
    System.out.println(URLEncoder.encode(URLEncoder.encode(cn, "UTF-8"), "UTF-8"));
  }

  public static void main(String[] args) throws Exception {
    testCharset();
  }
}
