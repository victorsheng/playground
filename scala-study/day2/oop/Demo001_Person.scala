package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 *
 * 在Scala中，类并不用声明为public。
 * 在Scala文件中，文件名可以不用和类名一致
 * Scala源文件中可以包含多个类，所有这些类都具有公有可见性
 */
class Demo001_Person {
    
    //类成员必须初始化
    //用val修饰的变量是只读属性，有getter但没有setter，相当与Java中用final修饰的变量
    val id = 1000
    
    //用var修饰的变量既有getter又有setter
    var age: Int = 33
    
    //类私有字段,只能在类的内部或伴生对象中使用
    private var name: String = "黄渤"
    
    //对象私有字段,访问权限更加严格，只有Student类的方法才能访问，伴生对象都不能访问
    private[this] val nickname = "影帝"
    
    private def add(x: Int) = {
        x + 1
    }
    
    // 方法和属性一样。
    private[this] def add1(x: Int) = {
        x + 1
    }
}

object Demo001_Person {
    
    def main(args: Array[String]): Unit = {
        
        val p = new Demo001_Person()
        
        // id是val修饰，那么只能访问，不能修改
        println(p.id)
        //    p.id = 22   // val修饰的成员变量不能被修改
        
        // age是var类型变量，所以既能修改，又能访问
        p.age = 44
        println(p.age)
        
        // name是private var修饰，所以除了自己能访问之外， 也只有伴生对象能访问了。
        p.name = "黄渤111"
        println(p.name)
        
        println(p.add(3))
        //  println(p.add1(5))    // private[this] 修饰的成员属性或者方法，不能被伴生对象访问
        
    }
}
