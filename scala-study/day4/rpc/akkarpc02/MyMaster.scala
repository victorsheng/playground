package day4.rpc.akkarpc02

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * 初始化一个 MasterActor
 */
class MyMaster extends Actor {
    
    override def receive = {
        case "hello" => doHello()
        case _ => doElse()
    }
    
    def doElse(): Unit = {
        println("接收到非法消息")
    }
    
    def doHello(): Unit = {
        println("我是Master, 收到客户端发来的问候： hello")
        // 发回消息 hi
        sender() ! "hi"
    }
}

object MyMaster {
    
    def main(args: Array[String]): Unit = {
        
        val str =
            """
              |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
              |akka.remote.netty.tcp.hostname = localhost
              |akka.remote.netty.tcp.port=6789
      """.stripMargin
        
        try {
            val config = ConfigFactory.parseString(str)
            val actorSystem = ActorSystem("MasterActorSystem", config)
            actorSystem.actorOf(Props(new MyMaster), "MasterActor")
        } catch {
            case e: Exception => println(e.getMessage)
        }
    }
}
