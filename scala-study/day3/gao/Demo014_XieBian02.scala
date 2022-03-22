package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/17 8:35
 *
 * 描述：
 */
object XieBianTest2 {
    
    def main(args: Array[String]): Unit = {
        
        val list: List[Any] = new List[String]("光环国际", null)
        
    }
}

class List[+T](val head: T, val tail: List[T]) {
    
    def prepend[U >: T](newHead: U): List[U] = new List(newHead, this)
    
    override def toString = "" + head
}



