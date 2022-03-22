package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:33
 * 描述： 函数和方法的使用
 */
object Demo010_MethodFunctionTrans {
    
    // 定义方法
    def m1(a: Int, b: Int): Int = {
        a + b
    }
    
    def m2(f: Int => Int, a: Int) = {
        f(a)
    }
    
    def m3(a: Int) = {
        a + 1
    }
    
    val f1 = (x: Int) => x + 1
    val ff = (f: Int => Int, x: Int) => f(x)
    
    def main(args: Array[String]): Unit = {
        
        // 把方法作为方法的参数
        println(m2(m3, 4))
        
        // 把函数作为方法的参数
        println(m2(f1, 4))
        
        // 函数当做函数的参数
        println(ff(f1, 4))
        
        // 方法当做函数的参数
        println(ff(m3, 4))
    }
}
