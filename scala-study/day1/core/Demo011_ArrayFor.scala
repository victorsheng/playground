package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo011_ArrayFor {
    
    def main(args: Array[String]) {
        //初始化一个数组
        val arr = Array(1, 2, 3, 4, 5, 6, 7, 8)
        
        //增强for循环
        for (i <- arr) {
            println(i)
        }
        
        //使用to可以生成一个序列作为脚标
        for (i <- (0 to arr.length - 1).reverse)
            println(arr(i))
        
        //好用的until会生成一个Range,reverse是将前面生成的Range反转
        for (i <- (0 until arr.length).reverse)
            println(arr(i))
        
        //步长为2
        for (i <- (0 until(arr.length, 2)).reverse)
            println(arr(i))
    }
}