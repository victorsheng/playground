package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/9/30 8:40
 * 描述： Scala的HelloWorld程序
 *
 * 核心要点：
 *
 * 1、类名和文件名
 * 2、main方法的定义(注意和java的main方法对比理解)
 * 3、分号(可有可无)
 * 4、编译和执行(scalac和scala)
 * 5、类的声明(object和class)
 */
object Demo000_HelloWorld {
    
    var name: String = "zhangsan"
    
    def main(args: Array[String]): Unit = {
        println("hello world")
        println(name)
    }
    
    def main1(args: Array[String]) {
        println(name)
    }
}
