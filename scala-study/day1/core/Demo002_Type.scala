package day1.core

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/12 12:58
 * 描述： 数据类型
 *
 * 要点：
 * 1、Any是所有类的父类，包括值类型AnyVal，和引用类型AnyRef
 * 2、AnyVal是所有值类型的父类，包括Int，Double，Boolean，Unit等等
 * 3、AnyRef是所有引用类型的父类，包括Null
 * 4、Null是所有引用类型的子类
 * 5、Nothing是所有类的子类
 * 6、Unit类型只有一个实例，是()，相当于java中的void，没有任何的实质意义
 * 7、Null也只有一个实例，是null，相当于java中的null，能赋值给任何引用类型变量，不能赋值给值类型变量
 */
object Demo002_Type {
    
    def main(args: Array[String]): Unit = {
        
        val var_int = 1
        val var_double = 3.33
        val var_float = 2.4F
        val var_char = 'A'
        val var_bool = true
        println(var_int, var_double, var_float, var_char, var_bool)
        
        val var_16 = 0x29
        val var_string = "aa"
        val var_string1 = "\"huangbo\""
        val var_string2 = """hello\thello\na\t\\"""
        
        println(var_16)
        println(var_string)
        println(var_string1)
        println(var_string2)
        
    }
}
