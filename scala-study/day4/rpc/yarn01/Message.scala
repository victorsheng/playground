package day4.rpc.yarn01

//注册消息   nodemanager  -> resourcemanager
case class RegisterNodeManager(val nodemanagerid: String, val memory: Int, val cpu: Int)

//注册完成消息 resourcemanager -> nodemanager
case class RegisteredNodeManager(val resourcemanagerhostname: String)

//心跳消息  nodemanager -> resourcemanager
case class Heartbeat(val nodemanagerid: String)

class NodeManagerInfo(val nodemanagerid: String, val memory: Int, val cpu: Int) {
    var lastHeartBeatTime: Long = _
    
    override def toString: String = {
        nodemanagerid + "," + memory + "," + cpu
    }
}

//单例
case object SendMessage

case object CheckTimeOut