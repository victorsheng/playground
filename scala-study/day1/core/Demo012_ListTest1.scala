package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/10/7 16:36
 * 描述： List的常用方法测试
 */
object Demo012_ListTest1 {
    
    def main(args: Array[String]): Unit = {
        
        //创建一个List
        val list0 = List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)
        //将list0中每个元素乘以10后生成一个新的集合
        val list1 = list0.map(x => x * 2)
        //结果是：List(2, 14, 18, 16, 0, 6, 10, 8, 12, 4)
        println(list1)
        println(list0(1))
        
        //将list0中的偶数取出来生成一个新的集合
        val list2 = list0.filter(x => x % 2 == 0)
        //运行结果是：List(8, 0, 4, 6, 2)
        println(list2)
        
        //将list0排序后生成一个新的集合
        val list3 = list0.sorted
        //运行结果：List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(list3)
        
        val list4 = list0.sortBy(x => x)
        //运行结果：List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(list4)
        
        val list5 = list0.sortWith((x, y) => x < y)
        //运行结果：List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(list5)
        println("--------------------------------1----------------------------------")
        
        //反转顺序
        val list6 = list3.reverse
        //运行结果：List(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        println(list6)
        
        //将Iterator转换成List
        val list7 = list0.toList
        //运行结果是：List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)
        println(list7)
        
        //先按空格切分，再压平
        val a = Array("a b c", "d e f", "h i j")
        a.flatMap(_.split(" "))
        //运行结果是：[Ljava.lang.String;@54a097cc
        println(a)
        
        val value1 = list0.reduce(_ + _)
        //运行结果是：45
        println(value1)
        
        val value2 = list0.fold(10)(_ + _)
        //运行结果是：55
        println(value2)
        println("--------------------------------2----------------------------------")
        
        //并行计算求和
        val value3 = list0.par.sum
        //运行结果是：45
        println(value3)
        
        val value4 = list0.par.map(_ % 2 == 0)
        //运行结果：ParVector(false, false, false, true, true, false, false, true, true, true)
        println(value4)
        
        val value5 = list0.par.reduce((x, y) => x + y)
        //运行结果：45
        println(value5)
        
        //简化：reduce
        //将非特定顺序的二元操作应用到所有元素
        val list9 = list0.par.reduce((x, y) => x + y)
        //运行结果是：45
        println(list9)
        
        //按照特定的顺序
        val list10 = list0.reduceLeft(_ + _)
        //运行结果：45
        println(list10)
        println("--------------------------------3----------------------------------")
        
        //折叠：有初始值（无特定顺序）
        val list11 = list0.par.fold(100)((x, y) => x + y)
        //运行结果是：945，第二次是1045，最后又回到945
        println(list11)
        
        //折叠：有初始值（有特定顺序）
        val list12 = list0.foldLeft(100)((x, y) => x + y)
        //运行结果一直是145
        println(list12)
        
        //聚合
        val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))
        val result = arr.aggregate(0)(_ + _.sum, _ + _)
        //运行结果：20
        println(result)
        
        val l1 = List(5, 6, 4, 7)
        val l2 = List(1, 2, 3, 4)
        //求并集
        val r1 = l1.union(l2)
        //结果是：List(5, 6, 4, 7, 1, 2, 3, 4)
        println(r1)
        
        //求交集
        val r2 = l1.intersect(l2)
        //运行结果：List(4)。并集只有一个4
        println(r2)
        
        //求差集
        val r3 = l1.diff(l2)
        //求l1中不包含l2元素的集合，运行结果是：List(5, 6, 7)
        println(r3)
    }
}
