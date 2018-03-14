package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TestInstanceCodeBlock {
    public static void main(final String[] args) {

        //匿名内部类
        Person person = new Person("张三"){
            @Override
            public String getName() {
                return super.getName()+"123";
            }

        };
        System.out.println(person.getName());

        //两个大括号的方式初始化(本质上是匿名内部类 + 实例化代码块儿)
        List<String> personList = new ArrayList<String>(){{
            add("AA");
            add("BB");
            add("CC");

        }};
        for (String s : personList){
            System.out.println(s);
        }
    }
}


class Person{
    String name;
    public Person(String name){
        this.name = name;
        System.out.println("构造方法执行...");
    }
    //实例化代码块儿,先于构造方法执行
    {
        System.out.println("实例初始化...");
    }
    public String getName(){
        return name;
    }

}
