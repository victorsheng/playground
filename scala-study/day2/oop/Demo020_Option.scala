package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述：
 * 在Scala中Option类型样例类用来表示可能存在或也可能不存在的值(Option的子类有Some和None)。
 * Some包装了某个值，None表示没有值
 */
object Demo020_Option {
    
    def main(args: Array[String]) {
        
        val map = Map("a" -> 1, "b" -> 2)
        
        // 第一种访问方式：如果key不存在会报错
        var v1 = map("a")
        println(v1)
        
        // 第二种访问方式：通过get方法获取， 如果key存在返回Some，如果key不存在返回None
        val v2 = map.get("b") match {
            case Some(i) => i
            case None => 0
        }
        println(v2)
        
        // 第三种方式： 更好的方式，可以指定当key不存在的时候返回一个默认值
        val v3 = map.getOrElse("c", 0)
        println(v3)
    }
}