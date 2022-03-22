package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言 隐式参数
 */
object Demo006_ImplicitParam {
    // 正常的普通方法
    def add(x: Int, y: Int) = x + y
    
    // 柯里化的方法
    def add2(x: Int)(y: Int) = x + y
    
    //  如果变成下面这种形式：
    def add3(x: Int)(implicit y: Int = 10) = x + y
    
    implicit var aa: Int = 3
    
    def main(args: Array[String]): Unit = {
        
        println(add(2, 3))
        // 不能只传一个参数取使用，必须要传入两个参数
        println(add2(2)(3))
        
        // 调用带隐式参数的函数
        println(add3(2))
    }
}
