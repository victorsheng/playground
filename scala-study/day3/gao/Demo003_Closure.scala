package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言的闭包测试
 */
object Demo003_Closure {
    
    def main(args: Array[String]): Unit = {
        
        var result = bibao()
        println(result(2))
        println(result(2))
        println(result(2))
        println(result(2))
    }
    
    // bibao是一个函数
    var bibao = () => {
        var sum = 0
        var add_sum = (x: Int) => {
            sum += x
            sum
        }
        add_sum
    }
}
