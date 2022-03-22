package day3.gao

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 类型界定
 */
class Demo011_GenericType02 {
    //  def compare[T](first:T,second:T)={
    def compare[T <: Comparable[T]](first: T, second: T) = {
        if (first.compareTo(second) > 0)
            first
        else
            second
    }
}

object Demo011_GenericType02 {
    
    def main(args: Array[String]): Unit = {
        
        val tvb = new Demo011_GenericType02
        println(tvb.compare("A", "B"))
        
    }
}
