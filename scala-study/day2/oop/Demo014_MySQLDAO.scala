package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述： 定义抽象类
 */
trait MySQLDAO {
    
    val id: Int
    val name: String = "huangbo"
    
    def add(o: Any): Boolean
    
    def update(o: Any): Int
    
    def query(id: String): List[Any]
    
    def delete(id: Int) = {
        println("delete one record")
    }
}

//如果有多个trait的话，则使用with关键字即可
class DaoImpl extends MySQLDAO with Cloneable {
    
    // 实现父类中的抽象方法，必须的
    def add(o: Any): Boolean = true
    
    def update(o: Any): Int = 1
    
    def query(id: String): List[Any] = List(1, 2, 3)
    
    // 给父类中的抽象字段赋值，必须的
    override val id = 12
}