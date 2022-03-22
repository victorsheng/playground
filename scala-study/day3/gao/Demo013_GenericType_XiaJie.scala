package day3.gao

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 */
object Demo013_GenericType_XiaJie {
    
    // 定义下界
    def getIDCard1[R >: Me](person: R): Unit = {
        println("好吧，他的身份证就交给你保管了");
    }
    
    // 定义上界
    def getIDCard2[R <: Me](person: R): Unit = {
        println("好吧，他的身份证就交给你保管了");
    }
    
    // 定义视图边界
    def getIDCard3[R <% Me](person: R): Unit = {
        println("好吧，他的身份证就交给你保管了");
    }
    
    def main(args: Array[String]): Unit = {
        
        getIDCard1[GranderFather](new GranderFather)
        getIDCard2[Son](new Son)
        getIDCard3[Me](new Me)
        
        // 这句代码会报错
        //    getIDCard[Tongzhuo](new Tongzhuo)
        
        implicit def tongzhuo2Me(tz: Tongzhuo): Me = new Me
        
        getIDCard3[Tongzhuo](new Tongzhuo)
    }
}

class GranderFather

class Father extends GranderFather

class Me extends Father

class Son extends Me

class Tongzhuo