package day3.gao

class Person77(val name: String) {
    override def toString() = name
}

class Student77(name: String) extends Person77(name)

class Teacher77(name: String) extends Person77(name)

class Pair[T](val first: T, val second: T) {
    override def toString() = "first:" + first + "    second: " + second;
}

/**
 * 类型通配符
 */
object TypeWildcard {
    
    def main(args: Array[String]): Unit = {
        
        makeFriends(new Pair(new Student77("黄渤学生"), new Teacher77("徐峥老师")))
        makeFriends(new Pair(new Student77("黄渤学生"), new Student77("徐峥学生")))
        makeFriends(new Pair(new Teacher77("黄渤老师"), new Student77("徐峥学生")))
        makeFriends(new Pair(new Teacher77("黄渤老师"), new Teacher77("徐峥老师")))
    }
    
    // Pair的类型参数限定为[_<:Person]，即输入的类为Person及其子类
    // 类型通配符和一般的泛型定义不一样，泛型在类定义时使用，而类型能配符号在使用类时使用
    def makeFriends(p: Pair[_ <: Person77]) = {
        println(p.first + " is making friend with " + p.second)
    }
}
