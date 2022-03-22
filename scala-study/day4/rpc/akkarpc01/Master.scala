package day4.rpc.akkarpc01

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

/**
 * 作者： 马中华
 * 主页： https://blog.csdn.net/zhongqi2513
 *
 * 描述：akka.tcp://MasterActorSystem@localhost:6789
 */
class Master extends Actor {
    
    def doHello(): Unit = {
        println("我是Master, 我接收到了Worker的hello的消息");
    }
    
    /**
     * 其实就是一个死循环:接收消息
     * while(true)
     */
    override def receive: Receive = {
        case "hello" => {
            // 模拟的业务方法
            doHello()
            //sender() 谁发送过来消息这个就是谁
            //sender()   ! "hi"  给sender()发送一个  hi  的消息
            sender() ! "hi"
        }
    }
}

object Master {
    
    def main(args: Array[String]): Unit = {
        val str =
            """
              |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
              |akka.remote.netty.tcp.hostname = localhost
              |akka.remote.netty.tcp.port = 6790
      """.stripMargin
        val conf: Config = ConfigFactory.parseString(str)
        
        // def apply(name: String, config: Config)
        val actorSystem = ActorSystem("MasterActorSystem", conf)
        
        //创建并启动actor   def actorOf(props: Props, name: String): ActorRef
        //new Master() 会导致主构造函数会运行！！
        actorSystem.actorOf(Props(new Master()), "MasterActor")
        
    }
}