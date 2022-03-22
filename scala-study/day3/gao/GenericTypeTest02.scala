//package com.aura.scala.day04
//
//object GenericTypeTest02 {
//
//  /**
//    * T是泛型，不确定是什么类型，所以不能确定T类型中，是否一定包含compareTo方法， 所以编译报错
//    * Comparable 接口    compareTo
//    *
//    * T <: Comparable[T]  语法结构：
//    *
//    *     表示将来传入进行的泛型的类型：T 必须是Comparable继承体系中的任何一员
//    *     T <: Comparable[T]    只认T是Comparable的子类
//    *     T <% Comparable[T]     除了会认识子类之外，还认识由其他的类隐式转换够来的类
//    *
//    */
//  def compare[T <% Comparable[T]](one:T, two:T):T = {
//    if(one.compareTo(two) > 0) one else two
//  }
//
//  def main(args: Array[String]): Unit = {
//
//    val stu1 = new Student66(1, "huangbo")
//    val stu2 = new Student66(2, "huangbo")
//    val student6 = compare[Student66](stu1, stu2)
//    println(student6)
//
//    import MyImplicit123.abc
//
//    val dog1 = new Dog66(1, "旺财")
//    val dog2 = new Dog66(2, "小黄")
//    val dog = compare[Dog66](dog1, dog2)
//    println(dog)
//  }
//}
//
//class Student66(val id:Double, val name:String) extends Comparable[Student66] {
//  override def compareTo(o: Student66): Int = {
//    val dd = this.id - o.id
//    dd.toInt
//  }
//}
//
//class Dog66(val id:Double, val name:String){}
//
//object MyImplicit123{
//  def abc(dog:Dog66):Student66 = new Student66(dog.id, dog.name)
//}
//
//
