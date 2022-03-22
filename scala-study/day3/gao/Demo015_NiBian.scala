package day3.gao

/**
 * 逆变测试
 */
object NibianTest {
    
    def main(args: Array[String]): Unit = {
    
    }
}

//声明逆变，不报错
class Person2[-A] {
    def test(x: A) {}
}

//声明协变，但会报错
/*class Person3[+A] {
  def test(x: A) {}
}*/

class Person4[+A] {
    def test[R >: A](x: R) {}
}

/**
 * 原因：
 * 对于Person3[Any] 和 Person3[String] 这两个父子类型来说
 * def test(x:Any){}
 * def test(x:String){}
 *
 * 由于+A协变，所以Person3[Any]是Person3[String]的父类
 *
 * 因此
 * val pAny = new Person3[AnyRef]
 * val pString = new Person3[String]
 *
 * pAny.test(123) 合法
 * pAny = pString 合法
 * 但是
 * pAny.test(123) 不合法
 */

