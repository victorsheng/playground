package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/8/27 8:48
 * 描述： 99乘法表
 */
object Demo021_99 {
    
    def main(args: Array[String]): Unit = {
        
        // 传统方式
        for (i <- 1 to 9) {
            for (j <- 1 to i) {
                printf("%d*%d=%2d\t", i, j, (i * j))
            }
            println()
        }
        
        println("-------------------------------------")
        
        // 新方式1
        for (i <- 1 to 9; j <- 1 to i) {
            printf("%d*%d=%2d\t", i, j, (i * j)); if (i == j) println()
        }
        
        // 新方式2
        for (i <- 1 to 9; j <- 1 to i) {
            print(s"$i*$j=${i * j}${if (i == j) "\n" else "\t"}")
        }
    }
}
