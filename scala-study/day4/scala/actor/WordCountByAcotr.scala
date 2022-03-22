package day4.scala.actor

import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/7 16:00
 * 描述： 使用Actor进行Wordcount
 *
 * 详情请参考：https://blog.csdn.net/tototuzuoquan/article/details/74058206
 */
object WordCountByAcotr {
    
    def main(args: Array[String]): Unit = {
        
        val replys = new ListBuffer[Future[Any]]
        val results = new ListBuffer[Map[String, Int]]
        val files = Array("D:\\bigdata\\wordcount\\input\\wc.txt")
        //每个文件就启动多少个actor,并将每个actor处理后得到的结果存储到List中
        for (f <- files) {
            val t = new WordCountByActorTask
            t.start()
            //通过SbTask的方式发送文件名
            val reply: Future[Any] = t !! SbTask(f)
            //将处理到的结果放到ListBuffer中。
            replys += reply
        }
        
        //对获得的replay的值进行计算。
        while (replys.size > 0) {
            val dones: ListBuffer[Future[Any]] = replys.filter(_.isSet)
            for (f <- dones) {
                //从relay中拿值，并将它转成map
                results += f.apply().asInstanceOf[Map[String, Int]]
                //计算完成之后，将这个replay移除掉。
                replys -= f
            }
            Thread.sleep(500)
        }
        
        val resultMap: Map[String, Int] = results.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
        
        for ((k, v) <- resultMap) {
            println(k, v)
        }
        
    }
}

case class SbTask(fn: String)

case object StopTask

class WordCountByActorTask extends Actor {
    override def act(): Unit = {
        while (true) {
            receive {
                case SbTask(f) => {
                    //通过Source.fromFile(f)读取文件，获取每行并且把它转换成List
                    val lines: List[String] = Source.fromFile(f).getLines().toList;
                    //将lines list里面的内容合并，然后并且将它split.
                    val words: List[String] = lines.flatMap(_.split(" "))
                    //将word这些单词变成map的并且是元组类型的，每个都是1，----,记着对他们进行过分组，接着就是计算单词
                    val result: Map[String, Int] = words.map((_, 1)).groupBy(_._1).mapValues(_.size)
                    sender ! result
                }
                case StopTask => {
                    exit()
                }
            }
        }
    }
}