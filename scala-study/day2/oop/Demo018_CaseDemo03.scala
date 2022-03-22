package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 匹配数组和元组
 */
object Demo018_CaseDemo03 extends App {
    
    val arr = Array(1, 3, 5, 6)
    arr match {
        //    case Array(1, x, y) => println(x + " " + y)
        case Array(0) => println("only 0")
        case Array(1, _*) => println("0 ...")
        case _ => println("something else")
    }
    println("----------------------------------------------------------")
    
    val lst = List(3, -1, 3)
    lst match {
        case 0 :: Nil => println("only 0")
        case x :: y :: Nil => println(s"x: $x y: $y")
        case 3 :: tail => println(tail)
        case _ => println("something else")
    }
    println("----------------------------------------------------------")
    
    val tup = (1, 2, 3, 7)
    tup match {
        //    case (1, x, y, z) => println(s"1, $x , $y, $z")
        case (_, z, 3, 7) => println(z)
        case _ => println("else")
    }
    println("----------------------------------------------------------")
    
    val ta = Array(Array(1, 2, 3), Array("a", "b", "c"))
    ta match {
        case Array(Array(x, y, z), _) => println(x, y, z)
        case _ => println("else")
    }
}
