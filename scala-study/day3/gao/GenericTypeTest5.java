package day3.gao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
 * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
 * 如果既要存又要取，那么就不要使用任何通配符。
 */
public class GenericTypeTest5 {

    public static void main(String[] args) {

        // 带有extends子类型限定的通配符可以向泛型对象读取。
        List<? extends Season> seasonList = new LinkedList<>();
//        seasonList.add(new Spring());
//        seasonList.add(new Summer());
        Season season = seasonList.get(0);
        Spring spring = (Spring) seasonList.get(1);

        // 带有super超类型限定的通配符可以向泛型对象中写入
        List<? super D> seasonList2 = new ArrayList<>();
//        seasonList2.add(new A());
//        seasonList2.add(new B());
//        seasonList2.add(new C());
    }
}

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

class Season {
}

class Spring extends Season {
}

class Summer extends Season {

}

class Demo<E> {
    public void extendsTest(List<? extends E> list) {
        System.out.println("extendsTest ok");
    }

    public void superTest(List<? super E> list) {
        System.out.println("superTest ok");
    }
}
