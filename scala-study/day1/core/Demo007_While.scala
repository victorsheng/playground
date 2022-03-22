package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 13:58
 * 描述： 流程控制 while
 */
object Demo007_While {
    def main(args: Array[String]) {
        
        // Scala中的while的语法和java中的一样
        var n = 10;
        while (n > 0) {
            println(n)
            n -= 1
        }
    }
}
