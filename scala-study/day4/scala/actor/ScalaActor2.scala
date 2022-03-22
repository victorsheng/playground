package day4.scala.actor

import scala.actors.Actor

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/17 13:15
 * 描述：
 * 说明：在act()方法中加入了while (true) 循环，就可以不停的接收消息
 * 注意：发送start消息和stop的消息是异步的，但是Actor接收到消息执行的过程是同步的按顺序执行
 */
object ScalaActor2 {
    
    def main(args: Array[String]): Unit = {
        
        val actor = new MyActor
        actor.start()
        //发送异步消息，感叹号就相当于是一个方法，可以在感叹号后面的字符串两边加载上括号
        actor ! "start"
        actor ! "stop"
        actor ! "hi"
        
        println("main线程代码执行完毕")
    }
}

class MyActor extends Actor {
    override def act(): Unit = {
        var flag = true
        while (flag) {
            receive {
                case "start" => {
                    println("starting...")
                    Thread.sleep(5000)
                    println("stared")
                }
                case "stop" => {
                    println("stoping ...")
                    Thread.sleep(5000)
                    println("stopped ...")
                }
                case _ => {
                    flag = false
                    println("工作线程程序终止")
                }
            }
        }
    }
}