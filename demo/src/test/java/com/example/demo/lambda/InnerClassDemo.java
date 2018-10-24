//package com.example.demo.lambda;
//
//public class InnerClassDemo {
//  public static void main(String[] args) {
//    Person person = new Person("Smarx", 23);
//    printPerson(person, new IPersonPrinter() {
//      public void printPerson(Person p) {
//        System.out.println(p.toString());
//      }
//    });
//  }
//
//  private static void printPerson(Person p, IPersonPrinter personPrinter){
//    personPrinter.printPerson(p);
//  }
//}
