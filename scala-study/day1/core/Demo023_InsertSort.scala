package day1.core

import scala.util.control.Breaks

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:51
 * 描述： Scala的插入排序
 */
object Demo023_InsertSort {
    
    def main(args: Array[String]): Unit = {
        
        val array = Array(4, 12, 6, 3, 8, 9, 5)
        val ab = array.toBuffer
        
        // 创建Breaks对象
        val forLoop = new Breaks
        
        for (i <- 1 until ab.length) {
            val value_i = ab(i)
            
            // 把需要可能break的代码放在 breakable 中执行
            forLoop.breakable {
                for (j <- 0 to i - 1) {
                    
                    val value_j = ab(j)
                    if (value_j > value_i) {
                        ab.remove(i, 1)
                        ab.insert(j, value_i)
                        
                        // 使用break进行跳出
                        forLoop.break()
                    }
                }
            }
        }
        println(ab)
    }
    
}
