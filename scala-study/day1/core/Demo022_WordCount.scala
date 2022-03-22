package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:49
 * 描述： wordcount
 */
object Demo022_WordCount {
    
    def main(args: Array[String]): Unit = {
        
        val array = Array("hello huangbo", "hello xuzheng", "hello wangbaoqiang")
        
        /**
         * 第一种方式
         */
        val result: List[(String, Int)] = array.flatMap(_.split(" "))
          .map((_, 1))
          .groupBy(t => t._1)
          .map(t => (t._1, t._2.length))
          .toList
          .sortBy(t => t._2)
          .reverse
        for (t <- result) {
            println(t)
        }
        println("------------------------------1------------------------------------")
        
        
        /**
         * 第二种方式
         */
        val result2: Map[String, Int] = array.flatMap(_.split(" "))
          .map(x => (x, 1))
          .groupBy(x => x._1)
          .mapValues(x => x.length)
        for ((k, v) <- result2) {
            println(k, v)
        }
        println("------------------------------2------------------------------------")
        
        
        /**
         * 第三种方式
         */
        val result3: Map[String, Int] = array.flatMap(_.split(" "))
          .map(x => (x, 1))
          .groupBy(x => x._1)
          .mapValues(x => x.foldLeft(0)((x, y) => x + y._2))
        for ((k, v) <- result3) {
            println(k, v)
        }
    }
}
