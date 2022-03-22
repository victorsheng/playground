package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/10/10 13:23
 * 描述： 泛型
 *
 * 泛型简单测试
 */
object Demo010_GenericType01 {
    
    def main(args: Array[String]): Unit = {
        
        println(new Student11[String, Int]("黄渤", 33).name)
        println(new Person11[String]("徐峥").name)
        
        val array = new Array[String](10)
        array(0) = "huangbo"
        //    array(1) = 11
        
    }
}

class Person11[T](var name: T) {}

class Student11[T, S](var name: T, var age: S) {}

