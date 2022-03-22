package day3.gao

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object XieBianTest {
    def main(args: Array[String]): Unit = {
        val list1: MyList[Any] = new MyList[AnyRef]("黄", null)
        val list2: MyList[Any] = new MyList[String]("黄", new MyList[String]("黄", null))
        
        val list3: MyList[String] = new MyList[String]("黄", null)
        val list4: MyList[Any] = new MyList[Object]("黄", list3)
        
        val abc: Any = "huangbo"
        list1.prepend[Any]("huangbo")
    }
}

class MyList[+T](val head: T, val tail: MyList[T]) {
    /**
     * 将函数也用泛型表示
     * 因为是协变的，输入的类型必须是T的超类
     * 这样返回值类型 MyList[U] 就是 MyList[T] 的超类。符合协变的性质
     */
    def prepend[U >: T](newHead: U): MyList[U] = new MyList(newHead, this)
    
    //  def prepend[T](newHead: T): MyList[T] = new MyList(newHead, this)
}