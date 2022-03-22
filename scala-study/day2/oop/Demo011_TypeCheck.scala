package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 类型检查测试
 */
object TypeCheckDemo {
    
    def main(args: Array[String]): Unit = {
        
        val s1 = new Student_11()
        val p1 = new People_11()
        val p2: People_11 = new Student_11()
        
        println(s1.isInstanceOf[Student_11])
        println(s1.isInstanceOf[People_11])
        println(p1.isInstanceOf[Student_11])
        println(p1.isInstanceOf[People_11])
        println("-------------------------------------------------")
        println(classOf[Student_11])
        println(s1.asInstanceOf[Student_11])
        println(p1.asInstanceOf[People_11])
        println(p2.asInstanceOf[People_11])
    }
}

class People_11 {

}

class Student_11 extends People_11 {

}