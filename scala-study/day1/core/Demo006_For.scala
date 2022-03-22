package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 13:58
 * 描述:  流程控制 for
 */
object Demo006_For {
    
    def main(args: Array[String]) {
        //for(i <- 表达式),表达式1 to 10返回一个Range（区间）
        //每次循环将区间中的一个值赋给i
        for (i <- 1 to 10)
            println(i)
        
        //for(i <- 数组)
        val arr = Array("a", "b", "c")
        for (i <- arr)
            println(i)
        
        // 倒序打印
        for (str <- arr.reverse) {
            println(str)
        }
        
        // 使用数组下标的方式进行打印
        for (i <- 0 to arr.length - 1) {
            println(arr(i))
        }
        
        for (i <- 0 until arr.length)
            println(arr(i))
        
        println("-----------------")
        for (i <- 0 until(arr.length, 2))
            println(arr(i))
        
        //高级for循环
        //每个生成器都可以带一个条件，注意：if前面没有分号
        for (i <- 1 to 3; j <- 1 to 3 if i != j)
            println((10 * i + j) + " ")
        println()
        
        //for推导式：如果for循环的循环体以yield开始，则该循环会构建出一个集合
        //每次迭代生成集合中的一个值
        val v = for (i <- 1 to 10) yield i * 10
        println(v)
        
    }
}