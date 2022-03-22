package day1.core

import util.control.Breaks._

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 13:58
 * 描述:  流程控制 break 和 continue
 */
object Demo007_Break_Continue {
    
    def main(args: Array[String]): Unit = {
        
        // break 举例
        breakable(
            for (i <- 1 to 5) {
                if (i == 3) {
                    break()
                }
                println(i)
            }
        )
        
        // continue 举例
        for (i <- 1 to 5) {
            breakable {
                if (i == 3) {
                    break
                }
                println(i)
            }
        }
        
    }
}
