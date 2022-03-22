package day2.oop

import scala.util.Random

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo018_CaseDemo01 extends App {
    val arr = Array("huangbo", "xuzheng", "wangbaoqiang", "xxxx")
    val name = arr(Random.nextInt(arr.length))
    
    // name模式匹配字符串
    name match {
        case "huangbo" => println("影帝来也...")
        case "xuzheng" => println("喜剧笑星来了...")
        case "wangbaoqiang" => println("实力干将来也...")
        case _ => println("谁...？？？")
    }
    
    case class SS(x: Int)
    
    val array = Array("huangbo", "xuzheng", "wangaboqiang", 5, SS(5))
    val value = array(Random.nextInt(array.length))
    println(value)
    value match {
        case "huangbo" => println("huangbo")
        case "xuzheng" => println("xuzheng")
        case z: Int if z > 6 => println(5)
        case zz: Int => println(55)
        case SS(xx) => println(xx)
        case _ => println("else")
    }
    
}
