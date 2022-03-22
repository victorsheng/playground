package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo012_ImmutableList {
    
    def main(args: Array[String]) {
        //创建一个不可变的集合
        val list1 = List(1, 2, 3)
        
        //将0插入到lst1的前面生成一个新的List
        val list2 = 0 :: list1
        val list3 = list1.::(0)
        val list4 = 0 +: list1
        val list5 = list1.+:(0)
        println(list2, list3, list4, list5)
        
        //将一个元素添加到lst1的后面产生一个新的集合
        val list6 = list1 :+ 3
        println(list6)
        
        val list0 = List(4, 5, 6)
        //将2个list合并成一个新的List
        val list7 = list1 ++ list0
        //将lst0插入到lst1前面生成一个新的集合
        val list8 = list1 ++: list0
        //将lst0插入到lst1前面生成一个新的集合
        val list9 = list1.:::(list0)
        println(list7)
        println(list8)
        println(list9)
    }
}

