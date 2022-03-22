package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 定义抽象类
 */
abstract class Animal {
    //抽象字段(域）
    //前面我们提到，一般类中定义字段的话必须初始化，而抽象类中则没有这要求
    var height: Int
    
    //抽象方法
    def eat: Unit
    
    val id: Int = 9
}

//Person继承Animal，对eat方法进行了实现
//通过主构造器对height参数进行了初始化
class Person11(var height: Int) extends Animal {
    
    //对父类中的方法进行实现，注意这里面可以不加override关键字
    def eat() = {
        println("eat by mouth")
    }
}

object Test1 {
    
    def main(args: Array[String]): Unit = {
        
        var p = new Person11(18)
        p.eat()
        
        println(p.id)
    }
}