package day2.oop

import scala.util.Random

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 样例类的模式匹配
 */
object CaseDemo04 extends App {
    
    val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))
    
    arr(Random.nextInt(arr.length)) match {
        case SubmitTask(id, name) => {
            println(s"$id, $name")
        }
        case HeartBeat(time) => {
            println(time)
        }
        case CheckTimeOutTask => {
            println("check")
        }
    }
}

// case class是多例， 后面必须带参数
// case obejct是单例
case class SubmitTask(id: String, name: String)

case class HeartBeat(time: Long)

case object CheckTimeOutTask