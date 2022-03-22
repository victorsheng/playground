package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 继承 测试
 */
object ExtendsDemo {
    def main(args: Array[String]): Unit = {
        val student = new Student_Exnteds("黄渤", 33, "1024")
        println(student.studentNo)
        student.eat("冰激凌")
    }
}

//Person类
class Person_Exnteds(name: String, age: Int) {
    println("Person_Exnteds : " + name + "\t" + age)
    
    def eat(what: String): Unit = println("我吃的是：" + what)
}

//Student继承Person类
class Student_Exnteds(name: String, age: Int, var studentNo: String) extends Person_Exnteds(name, age) {
    println("Student_Exnteds : " + name + "\t" + age + "\t" + studentNo)
    
    override def eat(what: String): Unit = super.eat(what)
}

