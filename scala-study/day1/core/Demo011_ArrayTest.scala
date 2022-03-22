package day1.core

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/10/8 8:37
 * 描述： 数组的一些常用其他方法
 */
object Demo011_ArrayTest {
    
    def main(args: Array[String]): Unit = {
        
        val array = Array(4, 2, 7, 8, 1, 2, 2, 8, 8, 9)
        
        val ab: ArrayBuffer[Int] = new ArrayBuffer[Int]()
        ab += (4, 3, 5, 6, 2, 7, 1, 8)
        
        val result11 = array.reduce((x: Int, y: Int) => x + y)
        println(result11)
        
        println(array.length)
        println(array.max)
        println(array.min)
        println(array.sum)
        println(array.mkString("-"))
        println(array.mkString("<", ",", ">"))
        println(array.filter((x: Int) => if (x % 2 == 0) true else false).toBuffer)
        ab.trimStart(2)
        println(ab)
        ab.trimEnd(2)
        println(ab)
        println("-----------------1-----------------")
        
        /**
         * array的map和reduce操作
         */
        val newArray: Array[Int] = array.map((x: Int) => x * 2)
        println(newArray.toBuffer)
        val newArray2: Int = array.reduce((x: Int, y: Int) => x + y)
        println(newArray2)
        println("-----------------2----------------")
        
        /**
         * fold操作
         */
        array.foldLeft[Int](0)((init, value) => {
            println(init, value);
            init + value
        })
        println("------------------3----------------")
        array.foldRight[Int](0)((init, value) => {
            println(init, value);
            init + value
        })
        val result: Int = array.fold(0)((x: Int, y: Int) => x + y)
        println(result)
        
        /**
         * array求平均值
         */
        val result2: (Int, Int) = array.map((x: Int) => (x, 1))
          .reduce((x: (Int, Int), y: (Int, Int)) => (x._1 + y._1, x._2 + y._2))
        println(result2._1 / result2._2.toDouble)
        println("-----------------4-----------------")
        
        /**
         * 排序
         */
        println(array.sorted.toBuffer)
        println(array.sortBy(x => x).reverse.toBuffer)
        println(array.sortWith((x: Int, y: Int) => x > y).toBuffer)
        Sorting.quickSort(array)
        println(array.toBuffer)
    }
}
