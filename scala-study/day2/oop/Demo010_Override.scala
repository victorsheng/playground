package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 定义抽象类
 */
object OverrideDemo {
    def main(args: Array[String]): Unit = {
        val student = new Student222
        student.eat()
    }
}

abstract class Person222 {
    def eat()
    
    def fly(): Unit = println("我能飞500公里")
}

class Student222 extends Person222 {
    // 因为父类是抽象类，所以override可以加可以不加
    override def eat(): Unit = {
        println("我要吃成金三胖")
        
        super.fly()
    }
}