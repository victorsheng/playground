package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:30
 * 描述： Scala的方法
 */
object Demo008_Method {
    
    def main(args: Array[String]): Unit = {
        println(max(2, 3))
        println(sub(4, 3))
        println(sub1(4, 3))
        
        println(decorate("Hello", "<<<", ">>>")) // <<<Hello>>>
        println(decorate("Hello", "<<<")) // <<<Hello]
        println(decorate(left = "<<<", str = "Hello", right = ">>>")) // 指定参数名，<<<Hello>>>
        println(decorate("Hello", right = ">>>")) // [Hello>>>
        
        println(sum(1, 2, 3, 4, 5))
        println(sum(4, 5, 6, 7, 8, 9))
        
        println(myPrint("huangbo"))
    }
    
    /**
     * def：关键字，定义一个函数
     * max：自定义的方法名
     * (x:Int, y:Int)：方法名后小扩号中为参数列表
     * Int：参数后的Int为方法返回值类型
     * {…}：大扩号中为方法体
     * =：如果没有等号, 表示该方法的返回值是Unit
     *
     * Scala函数返回值可以不加return,默认函数体最后一条语句为返回值
     * 函数体不指定返回值时，scala会根据实际类型进行类型推断
     * Unit关键字表示函数不存在返回值，相当于java中的void关键字
     * Scala每行语句结束后的分号可加可不加
     */
    def max(x: Int, y: Int): Int = {
        if (x > y) {
            x
        }
        else {
            y
        }
    }
    
    // 如果没有return语句，那么方法中的最后一行就是返回值
    def sub(a: Int, b: Int) = {
        a - b
    }
    
    // 方法中的最后一行就是返回值，也可以使用return显示声明这就是返回值。
    // 由于方法的定义中声明了，返回值就是Unit，所以sub1方法的返回值始终就是()，就算使用return进行返回也无济于事
    def sub1(a: Int, b: Int): Unit = {
        return a - b
    }
    
    // 如果定义一个方法，不需要返回值，那么可以省略 "="
    def myPrint(s: String) {
        println(s)
    }
    
    def myPrint1(s: String): Unit = {
        println(s)
    }
    
    // 定义带默认参数的方法
    def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
    
    // 定义变长参数方法
    def sum(args: Int*): Int = {
        var result = 0
        for (arg <- args) result += arg
        result
    }
}
