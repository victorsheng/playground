package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 13:00
 * 描述： 操作运算符
 *
 * 算术操作：+   -   *   /   %
 * 关系运算：>   >=   <   <=   ==   !=
 * 逻辑运算：&&   ||   !
 * 位运算： &   |   ^   >>   <<  >>>
 * 对象比较：1==1   1==1.0   "huangbo" == "huangbo"
 *
 */
object Demo003_Operator {
    
    def main(args: Array[String]): Unit = {
        
        println(7 + 3)
        println(7 - 3)
        println(7 * 3)
        println(7 / 3)
        println(7 % 3)
        
        println(7 > 3)
        println(7 >= 3)
        println(7 < 3)
        println(7 <= 3)
        println(7 == 3)
        println(7 != 3)
        
        println(true && false)
        println(true || false)
        println(!false)
        
        println(7 & 3) // 0111 & 011
        println(7 | 3) // 0111 & 011
        println(7 ^ 3) // 0111 & 011
        println(7 >> 1)
        println(7 << 1)
        println(-7 >>> 1)
        println(-7 >> 1)
        
        println(1 == 1)
        println(1 == 1.0)
        println("huangbo" == "huangbo")
        
        println("huangbo" equals "huangbo")
    }
}
