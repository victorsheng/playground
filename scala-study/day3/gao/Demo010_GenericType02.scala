package day3.gao

class Person[T, S](var name: T, var age: S)

class Student(var name: String, var age: Int) extends Comparable[Student] {
    override def compareTo(o: Student): Int = {
        return o.age - this.age
    }
}

/**
 * 泛型类
 */
class MrRight1[T <: Comparable[T]] {
    //定义一个选择方法，实现选择的功能
    def choose(first: T, second: T): T = {
        if (first.compareTo(second) > 0) first else second
    }
}

/**
 * 泛型方法
 */
class MrRight2 {
    def choose[T <: Comparable[T]](first: T, second: T): T = {
        if (first.compareTo(second) > 0) first else second
    }
}

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 泛型的基本测试
 *
 * 泛型类 和 泛型方法的测试
 */
object Demo010_GenericType02 {
    
    def main(args: Array[String]): Unit = {
        
        println(new Person[String, Int]("黄渤", 33).name)
        
        // 如果是类上定义的泛型，通过下面的方式调用
        val right1 = new MrRight1[Student]
        val hadoop1 = new Student("java", 77)
        val spark1 = new Student("scala", 88)
        val student1 = right1.choose(hadoop1, spark1)
        println(student1.name)
        
        //如果是在方法上定义的泛型，可以使用下面的方式：
        var right2 = new MrRight2
        val hadoop2 = new Student("hadoop", 99)
        val spark2 = new Student("spark", 88)
        val student2: Student = right2.choose[Student](hadoop2, spark2)
        println(student2.name)
    }
}