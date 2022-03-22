package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述：
 */
object Demo006_Apply {
    
    def main(args: Array[String]) {
        
        //调用了Array伴生对象的apply方法
        //def apply(x: Int, xs: Int*): Array[Int]
        //arr1中只有一个元素5
        val arr1 = Array(5)
        println(arr1.toBuffer)
        
        //new了一个长度为5的array，数组里面包含5个null
        var arr2 = new Array(5)
        
        
        val aabb = MyObject(3)
        println(aabb.abc)
    }
}

/**
 * 简单的Apply方法的自定义测试
 */
class MyObject {
    var abc: Int = 1
}

object MyObject {
    def apply(x: Int): MyObject = {
        val aa = new MyObject
        aa.abc = x
        aa
    }
}