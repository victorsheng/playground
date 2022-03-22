package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/10/10 13:12
 * 描述：
 */
object Demo009_Implicit_Type {
    
    def main(args: Array[String]): Unit = {
        
        // 定义一个隐式转换，能够、把一个double类型的数编程int类型。
        implicit def double2Int(a: Double) = a.toInt
        
        //    implicit def double2String(a:Double) = a.toString
        //    implicit def string2Int(s:String) = s.toInt
        
        // 定义三个方法
        def sum1(x: Int, y: Int) = x + y
        
        def sum2(x: Int, y: Double) = x + y
        
        def sum3(x: Double, y: Double) = x + y
        
        // 使用
        println(sum1(1, 2.0)) // 触发隐式转换
        println(sum2(1, 2)) // 触发隐式转换
        println(sum3(1, 2)) // 触发隐式转换
        
    }
}
