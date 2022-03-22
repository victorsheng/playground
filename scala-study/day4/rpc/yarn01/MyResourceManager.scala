package day4.rpc.yarn01

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable

/**
 * 作者： 马中华
 * 主页： https://blog.csdn.net/zhongqi2513
 */
class MyResourceManager(var hostname: String, var port: Int) extends Actor {
    
    // 用来存储每个注册的NodeManager节点的信息
    private var id2nodemanagerinfo = new mutable.HashMap[String, NodeManagerInfo]()
    // 对所有注册的NodeManager进行去重，其实就是一个HashSet
    private var nodemanagerInfoes = new mutable.HashSet[NodeManagerInfo]()
    
    // actor在最开始的时候，会执行一次
    override def preStart(): Unit = {
        import scala.concurrent.duration._
        import context.dispatcher
        
        // 调度一个任务， 每隔五秒钟执行一次
        context.system.scheduler.schedule(0 millis, 5000 millis, self, CheckTimeOut)
    }
    
    override def receive: Receive = {
        
        case RegisterNodeManager(nodemanagerid, memory, cpu) => {
            val nodeManagerInfo = new NodeManagerInfo(nodemanagerid, memory, cpu)
            println(s"节点 ${nodemanagerid} 上线")
            
            // 对注册的NodeManager节点进行存储管理
            id2nodemanagerinfo.put(nodemanagerid, nodeManagerInfo)
            nodemanagerInfoes += nodeManagerInfo
            
            //把信息存到zookeeper
            sender() ! RegisteredNodeManager(hostname + ":" + port)
        }
        
        case Heartbeat(nodemanagerid) => {
            val currentTime = System.currentTimeMillis()
            val nodeManagerInfo = id2nodemanagerinfo(nodemanagerid)
            nodeManagerInfo.lastHeartBeatTime = currentTime
            
            id2nodemanagerinfo(nodemanagerid) = nodeManagerInfo
            nodemanagerInfoes += nodeManagerInfo
        }
        
        // 检查过期失效的 NodeManager
        case CheckTimeOut => {
            val currentTime = System.currentTimeMillis()
            
            // 15 秒钟失效
            nodemanagerInfoes.filter(nm => {
                val bool = currentTime - nm.lastHeartBeatTime > 15000
                if (bool) {
                    println(s"节点 ${nm.nodemanagerid} 下线")
                }
                bool
            }).foreach(deadnm => {
                nodemanagerInfoes -= deadnm
                id2nodemanagerinfo.remove(deadnm.nodemanagerid)
            })
            println("当前注册成功的节点数" + nodemanagerInfoes.size + "\t分别是：" + nodemanagerInfoes.map(x => x.toString)
              .mkString(","));
        }
    }
}

object MyResourceManager {
    def main(args: Array[String]): Unit = {
        //    val RESOURCEMANAGER_HOSTNAME="localhost" //解析的配置的日志
        //    val RESOURCEMANAGER_PORT=6789
        val str =
        s"""
           |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
           |akka.remote.netty.tcp.hostname = localhost
           |akka.remote.netty.tcp.port = 6789
      """.stripMargin
        
        val conf = ConfigFactory.parseString(str)
        val actorSystem = ActorSystem(Constant.RMAS, conf)
        actorSystem.actorOf(Props(new MyResourceManager("localhost", 6789)), Constant.RMA)
    }
}
