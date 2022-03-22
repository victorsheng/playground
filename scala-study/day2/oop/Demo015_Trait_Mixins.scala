package day2.oop

trait MyLogger {
    def log(msg: String) {}
}

trait Logger_A extends MyLogger {
    override def log(msg: String): Unit = {
        println("AAAAAA : " + msg)
    }
}

trait Logger_B extends MyLogger {
    override def log(msg: String): Unit = {
        println("BBBBBB : " + msg)
    }
}

class Person123(val name: String) extends Logger_A {
    def sayHello(): Unit = {
        println("Hi ,i'm name")
        log("sayHello is invoked!")
    }
}

object MyLogger_Trait_Test {
    def main(args: Array[String]) {
        val p1 = new Person123("liudehua")
        p1.sayHello()
        
        val p2 = new Person123("zhangxueyou") with Logger_B
        p2.sayHello()
    }
}