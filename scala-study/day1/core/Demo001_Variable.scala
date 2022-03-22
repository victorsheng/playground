package day1.core

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo001_Variable {
    
    def main(args: Array[String]) {
        
        //使用val定义的变量值是不可变的，相当于java里用final修饰的变量
        val i = 1
        //使用var定义的变量是可变得，在Scala中鼓励使用val
        val s = "hello"
        //Scala编译器会自动推断变量的类型，必要的时候可以指定类型
        //变量名在前，类型在后
        val str: String = "NXNX奈学教育"
        println(i, s, str)
        
        /**
         * val 相当于Java中的final关键字修饰的变量，一旦赋值便不能更改
         * 当未指定类型时，Scala会根据实际类型进行类型推断,上面前三种方式结果相同
         * lazy关键字修饰的变量，定义时不赋值，真正使用时才赋值
         * var关键字修饰的变量，可以被重新赋值
         * e也可以是大写E,0.1214e1 = 0.1314*10
         * e也可以是大写E,0.1214e2 = 0.1314*10*10
         */
        
        // 定义变量
        val hello1 = "Hello Scala"
        val hello2: String = "Hello Scala"
        val hello3: java.lang.String = "Hello Scala"
        lazy val hello4 = "Hello Scala"
        
        // 使用val修饰的变量是不可更改变量。相当于java中的final关键字修饰的变量
        // 这个赋值操作是不被允许的： hello5 = "hello spark"
        val hello5 = "Hello Scala"
        
        
        // 使用var修饰的变量可以修改为同类型的其他值， 但是使用val修饰的变量一定不能修改
        var hello6 = "hello"
        // 这个赋值操作是错误的： hello6 = 4
        hello6 = "hi" // 这个操作是允许的
        
        val x1 = 0x29 //十六进制定义整数
        val x2 = 41 //十进制定义整数
        val x3 = 51 //八进制数定义
        println(x1, x2)
        
        val doubleNumber = 3.14159 //Double类型定义，直接输入浮点数，编译器会将其自动推断为Double类型
        val floatNumber1 = 3.14159F //定义Float类型浮点数，需要在浮点数后面加F或f
        val floatNumber2 = 0.1314e-1 // 科学计数法
        println(doubleNumber, floatNumber1, floatNumber2)
        
        // 字符定义，用单引号(')将字符包裹
        var letter = 'A'
        // 如果需要原样输出字符串中的内容，则用三个双引号"""将字符串包裹起来
        val hello = """Hello  \n \t \b \\ Scala"""
        // 定义布尔变量
        var bool = true
        println(letter, hello, bool)
    }
}
