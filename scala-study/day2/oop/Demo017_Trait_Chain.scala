package day2.oop

trait Handler {
    def handler(data: String) {}
}

trait Handler_A extends Handler {
    override def handler(data: String): Unit = {
        println("Handler_A :" + data)
        super.handler(data)
    }
}

trait Handler_B extends Handler {
    override def handler(data: String): Unit = {
        println("Handler_B :" + data)
        super.handler(data)
    }
}

trait Handler_C extends Handler {
    override def handler(data: String): Unit = {
        println("Handler_C :" + data)
        super.handler(data)
    }
}

class Person_TraitChain(val name: String) extends Handler_C with Handler_B with Handler_A {
    def sayHello = {
        println("Hello " + name)
        handler(name)
    }
}

object TraitChain_Test {
    def main(args: Array[String]) {
        val p = new Person_TraitChain("zhangxiaolong");
        p.sayHello
    }
}