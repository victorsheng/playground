package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 偏函数
 *
 * 被包在花括号内没有match的一组case语句是一个偏函数，
 * 它是PartialFunction[A, B]的一个实例
 * A代表参数类型，B代表返回类型，常用作输入模式匹配
 */
object Demo021_PartialFunc {
    
    def func1: PartialFunction[String, Int] = {
        case "one" => 1
        case "two" => 2
        case _ => -1
    }
    
    def func2(num: String): Int = num match {
        case "one" => 1
        case "two" => 2
        case _ => -1
    }
    
    def fun3: PartialFunction[Array[Int], String] = {
        //    case Array(_, x, y, z) => {println(x, y, z); x+"-"+y+"-"+z}
        case Array(1, 2, 3, z) => {
            println(z);
            z + "......."
        }
        case _ => {
            println("else");
            ""
        }
    }
    
    def main(args: Array[String]) {
        println(func1("one"))
        println(func2("one"))
        println(fun3(Array(1, 2, 3, 4)))
    }
}