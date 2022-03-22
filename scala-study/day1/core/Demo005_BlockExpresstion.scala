package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 13:58
 * 描述:  块表达式
 */
object Demo005_BlockExpresstion {
    
    def main(args: Array[String]) {
        val x = 0
        //在scala中{}中课包含一系列表达式，块中最后一个表达式的值就是块的值
        //下面就是一个块表达式
        val result = {
            if (x < 0) {
                -1
            } else if (x >= 1) {
                1
            } else {
                "error"
            }
        }
        //result的值就是块表达式的结果
        println(result)
        
        //返回块中的最后一个表达式的值
        val aa = {
            1 to 10; if (3 > 2) 3 else 2
        }
        println(aa)
        
        val bb = {
            1 to 10; if (3 > 2) 3 else 2; val cc = 2
        }
        println(bb)
    }
}