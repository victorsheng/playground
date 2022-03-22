package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:48
 * 描述：
 */
object Demo015_Tuple {
    
    def main(args: Array[String]): Unit = {
        
        // 声明一个Tuple
        val t = ("huangbo", 22, 55.55, true)
        
        // 声明一个Tuple
        val t1, (a, b, c, d) = ("huangbo", 22, 55.55, true)
        
        // 打印输出一个Tuple
        println(t1)
        println(a, b, c, d)
        
        // 访问Tuple对应位置上的元素
        val aa = t1._1
        println(aa, t1._2, t1._3)
        
        // 将元素是 二元组 的集合转换成Map
        var array = Array(("A", 1), ("B", 2))
        val map1 = array.toMap
        println(map1)
        
        // 可以将一个map转成一个 二元组 的数组
        val tuple1 = map1.toArray
        println(tuple1.toBuffer)
        
        // 如果只需要使用元组中的部分元素呢。
        val (aa1, _, bb1, _) = t1
        println(aa1, bb1)
        
        // List的拉链操作
        val alist = List("a", "b", "c")
        val blist = List(1, 2, 3)
        val result33: Map[String, Int] = alist.zip(blist).toMap
        println(result33)
    }
}
