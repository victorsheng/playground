package day1.core

import scala.collection.mutable

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo014_MutableMap extends App {
    
    val map1 = new mutable.HashMap[String, Int]()
    
    //向map中添加数据
    map1("spark") = 1
    map1 += (("hadoop", 2))
    map1.put("storm", 3)
    println(map1)
    
    //从map中移除元素
    map1 -= "spark"
    map1.remove("hadoop")
    println(map1)
    println("----------------------1--------------------------------------------")
    
    // 访问map1中的key-value
    println(map1("storm"))
    //  println(map1("spark"))
    val result = if (map1.contains("spark")) map1("spark") else 0
    println(result)
    println(map1.get("storm"))
    println(map1.getOrElse("storm", 0))
    println(map1.getOrElse("spark", 0))
    println("----------------------2--------------------------------------------")
    
    // 遍历
    val map2 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    for (kv <- map2) {
        println(kv._1, kv._2)
    }
    for ((k, v) <- map2) {
        println(k, v)
    }
    println("----------------------3--------------------------------------------")
}