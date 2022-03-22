package day1.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求来源：在Scala中：
 * def m(f : Int => Int, a:Int) = f(a)
 * val f1 = (x:Int) => x + 1
 * val f2 = (x:Int) => x * x
 * println(m(f1, 2))
 * println(m(f2, 2))
 * 怎么让Java实现类似的功能？
 *
 * 难点：
 *
 * 1、使用装饰器设计模式来增强已有的组件List的功能： 定义一个map方法
 *
 * 2、map方法中要传入的是一个自定的处理逻辑，也就相当于传入一个方法作为参数，但是Java不支持传入方法
 * 只支持传入数据对象或者引用对象。
 *
 * 3、解决方案：封装处理逻辑在对应的一个处理对象中的一个处理方法中， 不传入对象，但是可以传入一个处理对象
 */
public class Demo010_MyList {

    private List<Integer> list;

    public Demo010_MyList(List<Integer> list) {
        this.list = list;

    }

    /**
     * 如果需要什么样的逻辑，就在MyList1类中定义什么样的方法，这种方式不好维护和扩展
     */
    public List<Integer> map1() {

        // 返回一个新的List还是直接作用在原来的List之上，随自己指定
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            int newResult = i + 1;
            newList.add(newResult);
        }
        return newList;
    }

    /**
     * 其实表面上传入了方法， 但事实上， 传入了一个处理数据的逻辑
     */
    public List<Integer> map(MapOperation o) {

        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {

            // 这个地方，这句代码才是真正的处理原来的数据
            // int newResult = i+1;
            int newResult = o.operate(i);

            newList.add(newResult);
        }
        return newList;
    }

    public List<Integer> reduce(ReduceOperator reduceOperator) {
        return null;
    }

    /**
     * 接口： 封装数据的逻辑， 成为接口， 就是为了统一规范
     * 作用： 接收一个参数值， 返回一个值
     */
    interface MapOperation {
        Integer operate(Integer i);
    }

    /**
     * 接口： 封装数据的逻辑， 成为接口， 就是为了统一规范
     * 作用： 接收两个参数值， 返回一个值
     */
    interface ReduceOperator {
        Integer operate(Integer x, Integer y);
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Demo010_MyList myList = new Demo010_MyList(list);

        List<Integer> newList = myList.map(new MapOperation() {
            @Override
            public Integer operate(Integer i) {
                return i * 100 - 5;
            }
        });

        for (Integer i : newList) {
            System.out.println(i);
        }
    }
}
