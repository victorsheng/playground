package day2.oop

import scala.collection.mutable.ArrayBuffer

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object SingletonDemo {
    def main(args: Array[String]) {
        //单例对象，不需要new，用【类名.方法】调用对象中的方法
        val session = SessionFactory.getSession()
        println(session)
    }
}

object SessionFactory {
    
    //该部分相当于java中的静态块
    var counts = 5
    val sessions = new ArrayBuffer[Session]()
    while (counts > 0) {
        sessions += new Session
        counts -= 1
    }
    
    //在object中的方法相当于java中的静态方法
    def getSession(): Session = {
        sessions.remove(0)
    }
}

class Session {
}