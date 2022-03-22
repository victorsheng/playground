package day4.scala.actor

import scala.actors.Actor

case class SyncMsg(id: Int, msg: String)

case class AsyncMsg(id: Int, msg: String)

case class ReplyMsg(id: Int, msg: String)

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/7 15:55
 * 描述：
 */
object ScalaActor4 {
    
    def main(args: Array[String]): Unit = {
        
        val a = new AppleActor
        a.start()
        //异步消息
        a ! AsyncMsg(1, "hello actor")
        println("异步消息发送完成")
        
        //同步消息(因为这里的最长时间是1秒，但是SyncMsg中休眠的时间更长，为5秒，所以这里是None)
        //同步消息，表示需要等待
        val content = a !? (1000, SyncMsg(2, "hello actor"))
        println(content)
        
        //异步但是返回结果，这个结果会被放到future中。然后进行返回。
        val reply = a !! SyncMsg(2, "hello actor")
        //replay是否已经完成通过isSet类判断
        println(reply.isSet);
        
        println("123")
        
        //通过apply方法拿到里面的值，这个apply是feture中的方法。
        val c = reply.apply()
        //拿到之后，reply中的值相当于被设置了。所以c为true
        println(reply.isSet)
        println(c)
        
    }
}

class AppleActor extends Actor {
    
    def act(): Unit = {
        while (true) {
            receive {
                case "start" => println("starting ...")
                
                case SyncMsg(id, msg) => {
                    println(id + ",sync " + msg)
                    Thread.sleep(5000)
                    //这里又开了一个子线程，这个在下面的方法中执行
                    //sender也是一个方法。看可以通过消息的发送者发送
                    sender ! ReplyMsg(3, "finished")
                }
                
                case AsyncMsg(id, msg) => {
                    println(id + ",async " + msg)
                    Thread.sleep(5000)
                }
            }
        }
    }
}

