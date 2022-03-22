package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/10/7 18:43
 * 描述： 柯里化
 * 原因：定义的方法的实现体是一个要接受另外一个参数的函数
 * 概念：柯里化（Currying）是把接受多个参数的函数变换成接受一个
 * 单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术。
 */
object Demo004_CurryTest1 {
    
    def main(args: Array[String]): Unit = {
        
        // 定义一个方法，但是方法的实现体是一个函数
        def m1(x: Int) = (y: Int) => x * y
        
        val func = m1(3)
        val result = func(5)
        println(result)
        println(m1(3)(5))
        
        // 事实上这种方式的调用就得等同于是：
        def m2(x: Int)(y: Int = 10) = x * y
        
        println(m2(3)(5))
        println(m2(9)()) // √√√√√
        //    println(m2(9)         // xxxxx
        
        def m3(x: Int)(implicit y: Int = 10) = x * y
        
        println(m3(3)(5))
        println(m3(3))
        println(m3(3)())
    }
}
