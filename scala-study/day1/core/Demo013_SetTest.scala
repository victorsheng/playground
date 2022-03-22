package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/10/8 13:31
 * 描述：
 */
object Demo013_SetTest {
    
    def main(args: Array[String]): Unit = {
        
        val set1: Set[Int] = Set(1, 2, 3, 4, 5)
        val set2: Set[Int] = Set(3, 4, 5, 6, 7)
        
        println(set1.union(set2))
        println(set1.intersect(set2))
        println(set1.diff(set2), set2.diff(set1))
    }
}
