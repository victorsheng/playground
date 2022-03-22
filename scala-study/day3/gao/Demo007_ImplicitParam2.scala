package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/10/10 8:31
 * 描述： 柯里化函数的隐式参数
 */
object Demo007_ImplicitParam2 {
    
    /**
     * 第一个参数是要换算成美元的人民币数目
     * 第二个参数是汇率
     */
    def rmb(dollar: Double)(implicit rate: Double = 6) = dollar * rate
    
    def main(args: Array[String]): Unit = {
        
        println(rmb(100))
        println(rmb(100)(7))
        
        // 引入隐式转换值，所以第二个参数被隐式的转换成了6.66
        import MyPredefX._
        println(rmb(100))
    }
    
}

object MyPredefX {
    // 声明一个Double类型的隐式转换值
    implicit var current_rate: Double = 6.66
}

