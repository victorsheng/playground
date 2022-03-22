package day4.rpc.akkarpc02

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * 初始化一个 WorkerActor
 */
class MyWorker extends Actor {
    
    override def receive = {
        case "hi" => doHi()
        case _ => doElse()
    }
    
    def doElse(): Unit = {
        println("接收到非法消息")
    }
    
    def doHi(): Unit = {
        println("我是Worker, 收到来自服务端的回复 Hi")
    }
    
    /**
     * 这个方法，是这个actor运行的时候，首先会被执行的
     * 可以用来初始化的给Master发送hello
     */
    override def preStart(): Unit = {
        
        val masterActor = context.actorSelection("akka.tcp://MasterActorSystem@localhost:6789/user/MasterActor")
        masterActor ! "hello"
    }
}

object MyWorker {
    
    def main(args: Array[String]): Unit = {
        
        val str =
            """
              |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
              |akka.remote.netty.tcp.hostname = localhost
      """.stripMargin
        val config = ConfigFactory.parseString(str)
        
        try {
            val workerActorSystem = ActorSystem("WorkerActorSystem", config)
            
            workerActorSystem.actorOf(Props(new MyWorker), "WorkerActor")
        } catch {
            case e: Exception => println(e.getMessage)
        }
    }
}
