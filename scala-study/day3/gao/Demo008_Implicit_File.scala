package day3.gao

import java.io.File

import scala.io.Source

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言的隐式转换
 */
object FileImplicit {
    
    def main(args: Array[String]): Unit = {
        
        try {
            import MyPredef._
            val file = new File("C:\\words.txt").readAll()
            println(file)
            
            //      throw  new Exception("xxx")
        } catch {
            case e: Exception => println(e)
        }
    }
}

class RichFile(f: File) {
    def readAll(): String = {
        Source.fromFile(f).mkString
    }
}

object MyPredef {
    
    implicit def fileToRichFile(f: File): RichFile = new RichFile(f)
}
