package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 *
 * 类主构造器可以有默认参数
 * 当主构造器的参数不用var或val修饰的时候，参数会生成类的私有val成员，并且不会产生getter和setter方法
 */
class Demo002_Person_Constructor(val name: String = "黄渤", private val age: Int = 18, xxx: Int) {
    println("调用了主构造器")
    
    val id = "100"
    private[this] val nickname = "影帝"
    
    // xxx 参数被方法使用了之后，就变成了该类私有的字段。伴生对象也不能访问
    println(xxx)
    
    def add(x: Int) = x + xxx
}

object Demo002_Person_Constructor {
    
    def main(args: Array[String]): Unit = {
        val p = new Demo002_Person_Constructor("徐峥", 22, 33)
        println(p.name)
        
        // 如果不是在Person_Constructor的伴生对象中，那么是不能进行访问的
        println(p.age)
        println(p.id)
        
    }
}
