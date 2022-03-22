package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： 柯里化 测试
 */
object Demo005_CurryTest2 {
    
    def multiply1(x: Int)(y: Int) = x * y
    
    //柯里化就是把参数可以分开来，把部分函数参数可以用下划线来代替
    def multiply2 = multiply1(2) _
    
    // 一个普通的方法，接受两个Int类型参数做乘积
    def multiply3(x: Int, y: Int) = x * y
    
    def multiply4(x: Int, y: Int = 10) = x * y
    
    def multiply5(x: Int)(y: Int = 10) = x * y
    
    def main(args: Array[String]): Unit = {
        println(multiply1(2)(4))
        println(multiply2(4))
        
        // 跟柯里化的函数在结果上没有区别，那到底有什么区别呢？
        println(multiply3(2, 4))
        
        println(multiply4(4))
        println(multiply5(4)())
        
    }
}
