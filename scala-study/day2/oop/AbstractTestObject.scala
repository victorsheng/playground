package day2.oop

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2019/4/22 13:48
 * 描述：
 */
object AbstractTestObject {
    
    def main(args: Array[String]): Unit = {
        
        new AbstractTest2("aa") {
            override def eat(): Unit = {
                println(name)
            }
        }.eat()
    }
}

trait AbstractTest1 {
}

abstract class AbstractTest2(var name: String) {
    def eat(): Unit
}


