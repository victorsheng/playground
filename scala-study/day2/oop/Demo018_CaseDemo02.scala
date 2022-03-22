package day2.oop

import scala.util.Random

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object CaseDemo02 extends App {
    //val v = if(x >= 5) 1 else if(x < 2) 2.0 else "hello"
    val arr = Array("hello", 1, 2.0, CaseDemo)
    val v = arr(Random.nextInt(4))
    println(v)
    
    // 模式匹配
    v match {
        case x: Int => println("Int " + x)
        case y: Double if (y >= 0) => println("Double " + y)
        case z: String => println("String " + z)
        case _ => throw new Exception("not match exception")
    }
}

case class CaseDemo()
