package day4.rpc.akkarpc01

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * 作者： 马中华
 * 主页： https://blog.csdn.net/zhongqi2513
 */
class Worker extends Actor { //生命周期
    
    def doHi(): Unit = {
        println("我是Worker，我接收到了Master的hi的消息");
    }
    
    //如果actor一执行首先运行的是这个方法，只运行一次。
    override def preStart(): Unit = {
        //实现的是给 Master 发送消息  地址
        val workerActor = context.actorSelection("akka.tcp://MasterActorSystem@localhost:6790/user/MasterActor")
        workerActor ! "hello"
    }
    
    override def receive: Receive = {
        case "hi" => {
            doHi()
        }
    }
    
}

object Worker {
    def main(args: Array[String]): Unit = {
        
        val str =
            """
              |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
              |akka.remote.netty.tcp.hostname = localhost
      """.stripMargin
        
        val conf = ConfigFactory.parseString(str)
        val actorSystem = ActorSystem("WorkerActorSystem", conf)
        actorSystem.actorOf(Props(new Worker()), "WorkerActor")
    }
}
