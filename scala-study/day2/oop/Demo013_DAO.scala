package day2.oop

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
trait Demo013_DAO {
    
    //抽象字段
    val id: Int
    //具体字段
    val name: String = "huangbo"
    
    //带实现的具体方法
    def delete(id: String): Boolean = true
    
    //定义一个抽象方法，注意不需要加abstract,加了abstract反而会报错
    def add(o: Any): Boolean
    
    // 抽象方法
    def update(o: Any): Int
    
    def query(id: String): List[Any]
}