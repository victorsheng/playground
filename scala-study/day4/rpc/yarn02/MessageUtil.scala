package day4.rpc.yarn02

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/17 13:27
 *
 * 描述：
 */
object MessageUtil {}

// 注册消息
case class RegisterNodeManager(var nodemanagerid: String, var memory: Int, var cpu: Int)

// 心跳信息
case class HeartBeat(var nodemanagerid: String)

// CheckTimeOut
case object CheckTimeOut

class NodeManagerInfo(var nodemanagerid: String, var memory: Int, var cpu: Int) {
    var lastHeartBeatTime: Long = _
}