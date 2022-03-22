package day4.scala.actor

import scala.actors.Actor

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/17 13:11
 *
 * 描述： Scala Actor测试
 */
object ScalaActor {
    
    def main(args: Array[String]): Unit = {
        
        val mya = new Actor1
        mya.start()
        
        val myb = new Actor2
        myb.start()
    }
}

class Actor1 extends Actor {
    override def act(): Unit = {
        for (i <- 1 to 10) {
            println("actor-1 " + i)
            Thread.sleep(1000)
        }
    }
}

class Actor2 extends Actor {
    override def act(): Unit = {
        for (i <- 1 to 10) {
            println("actor-2 " + i)
            Thread.sleep(1000)
        }
    }
}
