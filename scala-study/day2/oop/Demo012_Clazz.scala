package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object ClazzDemo {
    def main(args: Array[String]) {
        val h = new Human
        println(h.fight)
    }
}

trait Flyable {
    def fly(): Unit = {
        println("I can fly")
    }
    
    def fight(): String
}

abstract class Animal1 {
    def run(): Int
    
    val name: String
}

class Human extends Animal1 with Flyable {
    
    val name = "abc"
    
    // 五个变量分别都赋值一次，那么{}也就相当于要执行五次
    val t1, t2, (a, b, c), t3, t4 = {
        println("ABC")
        (1, 2, 3)
    }
    
    println(a)
    println(t1._1)
    println(t1.hashCode() + "\t" + t2.hashCode())
    
    def fight(): String = {
        "fight with 棒子"
    }
    
    //在Scala中重写一个非抽象方法必须用override修饰
    override def fly(): Unit = {
        println("Human fly ......")
    }
    
    //在子类中重写超类的抽象方法时，不需要使用override关键字，写了也可以
    def run(): Int = {
        1
    }
}