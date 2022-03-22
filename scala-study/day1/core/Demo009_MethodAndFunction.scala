package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:30
 * 描述： Scala的方法 和 函数
 */
object Demo009_MethodAndFunction {
    
    //方法m1参数要求是一个函数，函数的参数必须是两个Int类型，返回值类型也是Int类型
    def m1(f: (Int, Int) => Int): Int = f(2, 6)
    
    // 定义一个需要两个Int类型参数的方法
    def m2(x: Int, y: Int): Int = x + y
    
    // 定义一个计算数据不被写死的方法
    def m3(f: (Int, Int) => Int, x: Int, y: Int): Int = f(x, y)
    
    // 定义一个函数f1，参数是两个Int类型，返回值是一个Int类型
    val f1 = (x: Int, y: Int) => x + y
    // 再定义一个函数f2
    val f2 = (m: Int, n: Int) => m * n
    // 定义一个传入函数的函数
    val f3 = (f: (Int, Int) => Int, x: Int, y: Int) => f(x, y)
    
    //main方法
    def main(args: Array[String]) {
        
        //调用m1方法，并传入f1函数
        val r1 = m1(f1)
        println(r1)
        
        //调用m1方法，并传入f2函数
        val r2 = m1(f2)
        println(r2)
        
        // 调用m3方法， 传入f1函数
        val result1 = m3(f1, 2, 4)
        println(result1)
        
        // 调用m3方法，传入f2函数
        val result2 = m3(f2, 2, 4)
        println(result2)
        
        // 调用m3方法， 传入m2方法作为参数
        println(m3(m2, 2, 4))
        
        // 调用f3函数， 传入f1函数
        println(f3(f1, 3, 4))
    }
}