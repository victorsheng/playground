package day4.rpc.yarn02

import akka.actor.Actor

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/17 13:22
 *
 * 描述：
 */
class MyResourceManager(var hostname: String, var port: Int) extends Actor {
    override def receive = {
        
        // 如果是注册信息
        case RegisterNodeManager(nodemanagerid, memory, cpu) => {
        
        }
        
        // 如果是心跳信息
        case HeartBeat(nodemanagerid) => {
        
        }
        
        // 如果是自己发送的检查的消息呢
        case CheckTimeOut => {
        
        }
        
    }
}
