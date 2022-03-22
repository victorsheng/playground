package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/10/7 19:43
 * 描述：
 */
object Demo012_ListTest2 {
    
    def main(args: Array[String]): Unit = {
        
        val list1: List[Int] = List.apply(1, 2, 3)
        println(list1)
        
        val list2: List[Int] = List.range(2, 6)
        val list3: List[Int] = List.range(2, 6, 2)
        val list4: List[Int] = List.range(2, 6, -1)
        println(list2)
        println(list3)
        println(list4)
        
        val list5: List[String] = List.fill(5)("hey")
        println(list5)
        
        val list6: List[String] = List.concat(List("a", "b"), List("c"))
        println(list6)
    }
}
