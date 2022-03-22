package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言的闭包测试
 */
object Demo003_Closure02 {
    
    def main(args: Array[String]): Unit = {
        
        // 定义一个函数ff，它的返回值是这个number, 并且这个函数作为ff2的返回值
        def ff2() = {
            var number = 100
            number
        }
        
        val result = ff2
        println(result)
        
    }
}
