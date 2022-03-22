package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
class Demo005_Dog {
    val id = 100
    private var name = "旺财"
    
    def printName(): Unit = {
        //在Dog类中可以访问伴生对象Dog的私有属性
        println(Demo005_Dog.CONSTANT + name)
    }
}

/**
 * 伴生对象
 */
object Demo005_Dog {
    
    //伴生对象中的私有属性
    private val CONSTANT: String = "汪汪汪 : "
    
    def main(args: Array[String]) {
        val p = new Demo005_Dog
        //访问私有的字段name
        p.name = "123"
        p.printName()
    }
}