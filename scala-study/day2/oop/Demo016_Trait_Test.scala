package day2.oop

abstract class Programmer {
    def getSkill(): String = "所有程序员都至少掌握一门编程语言。\n"
}

trait PHPer extends Programmer {
    override def getSkill() = super.getSkill() + "我掌握PHP。"
}

trait Scalaist extends Programmer {
    override def getSkill() = super.getSkill() + "我掌握Scala。"
}

trait Gopher extends Programmer {
    override def getSkill() = super.getSkill() + "我掌握Golang。"
}

trait Rustacean extends Programmer {
    override def getSkill() = super.getSkill() + "我掌握Rust。"
}

object TestTrait {
    
    def main(args: Array[String]): Unit = {
        
        val programmer1 = new Programmer with Scalaist with Gopher
        val programmer2 = new Programmer with Scalaist with Gopher with PHPer
        val programmer3 = new Programmer with Scalaist with Gopher with Rustacean
        val programmer4 = new Programmer with Scalaist with Gopher with PHPer with Rustacean
        
        println(programmer1.getSkill())
        println(programmer2.getSkill())
        println(programmer3.getSkill())
        println(programmer4.getSkill())
    }
}