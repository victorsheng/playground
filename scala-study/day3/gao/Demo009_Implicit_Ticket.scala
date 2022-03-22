package day3.gao

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/16 13:11
 *
 * 描述： Scala编程语言的隐式转换测试例子
 */
object ImplicitTest3 {
    def main(args: Array[String]): Unit = {
        val ticketHouse = new TicketHouse()
        val young = new Young("Young")
        val older = new Older("Older")
        val worker = new Worker("Worker")
        val adult = new Worker("Adult")
        
        import ObjectImplicit._
        //    ticketHouse.buyTicket(worker)    // 报错
        //    ticketHouse.buyTicket(adult)     // 报错
        ticketHouse.buyTicket(young)
        ticketHouse.buyTicket(older)
    }
}

object ObjectImplicit {
    /*implicit def object2special(obj:SpecialPerson):SpecialPerson={
      if(obj.getClass == classOf[Young]){
        val young = obj.asInstanceOf[Young]
        new SpecialPerson(young.name)
      }else if(obj.getClass == classOf[Older]){
        val older = obj.asInstanceOf[Older]
        new SpecialPerson(older.name)
      }else{
        new SpecialPerson("NULL")
      }*/
    
    implicit def object2special1(obj: Young): SpecialPerson = new SpecialPerson(obj.name)
    
    implicit def object2special2(obj: Older): SpecialPerson = new SpecialPerson(obj.name)
    
}

//特殊人群
class SpecialPerson(var name: String)

//特殊人群之一
class Young(var name: String)

//特殊人群之一
class Older(var name: String)

//正常人群之一
class Worker(var name: String)

//正常人群之二
class Adult(var name: String)

class TicketHouse {
    def buyTicket(p: SpecialPerson): Unit = {
        println(p.name + "票给你！！爽去吧！！");
    }
}