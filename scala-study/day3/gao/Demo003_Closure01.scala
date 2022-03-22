package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言的闭包测试
 */
object Demo003_Closure01 {
    
    def main(args: Array[String]): Unit = {
        
        // 如何在这个ff函数的外部访问到number这个变量的值
        def ff1(): Unit = {
            var number = 100
        }
        
        // 定义一个函数ff，它的返回值是这个number, 并且这个函数作为ff2的返回值
        def ff2() = {
            var number = 100
            val ff = () => {
                number
            }
            ff
        }
        
        val resultFunc = ff2()
        val result = resultFunc()
        println(result)
        
        // 调用过程中的细节
        def ff3() = {
            var number = 100
            val ff = (a: Int) => {
                number += a
                number
            }
            ff
        }
        
        val resultFunc3 = ff3()
        val result3 = resultFunc3(2)
        val result4 = resultFunc3(2)
        val result5 = resultFunc3(2)
        println(result3, result4, result5)
        
    }
}
