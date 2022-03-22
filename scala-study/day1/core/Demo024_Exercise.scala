package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 18:39
 * 描述： 练习
 * 保留所有正数
 * 移除list中的第一个负数
 * 移除list中出第一个负数外的所有负数
 */
object Demo024_Exercise {
    
    def main(args: Array[String]): Unit = {
        
        val list1 = List(1, 2, 3, -1, -2, -3)
        list1.foldLeft((0, 0))((x, y) => (x._1 + y, x._2 + 1))
        
        // 1、保留所有的正数
        list1.filter(x => if (x > 0) true else false).foreach(println)
        
        // 2、移除list1中的第一个负数得到List(1,2,3,-2,-3)
        var flag = 0
        list1.filter(x => {
            if (x < 0) flag += 1
            (x > 0 || flag >= 2)
        }).foreach(x => println(x))
        
        // 3、移除除第一个负数外的所有负数List(1,2,3,-1)
        var abc = 0
        list1.filter(x => {
            if (x < 0) abc += 1
            (x > 0 || abc <= 1)
        }).foreach(x => println(x))
        
        var array1 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val result1 = array1.foldLeft(10)((x: Int, y: Int) => x + y)
        println(result1)
        
        val result2 = array1.foldRight(10)((x: Int, y: Int) => x + y)
        println(result2)
        
        val tuple = array1.foldLeft((0, 0))((x, y) => (x._1 + y, x._2 + 1))
        println(tuple._1.toDouble / tuple._2)
    }
}
