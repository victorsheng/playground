package day4.scala.actor

import scala.actors.Actor

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/17 13:19
 * 描述：
 * react 类似线程池机制，可以复用线程。
 * react 方式会复用线程，比receive更高效
 * react 如果要反复执行消息处理，react外层要用loop，不能用while
 */
object ScalaActor3 {
    
    def main(args: Array[String]): Unit = {
        
        val actor = new YourActor
        actor.start()
        actor ! "start"
        actor ! "stop"
        println("消息发送完成!")
    }
}

class YourActor extends Actor {
    
    override def act(): Unit = {
        loop {
            //这里是一个偏函数
            react {
                case "start" => {
                    println("starting...")
                    Thread.sleep(5000)
                    println("started")
                }
                case "stop" => {
                    println("stopping...")
                    Thread.sleep(8000)
                    println("stopped")
                }
            }
        }
    }
}