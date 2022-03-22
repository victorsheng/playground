package day1.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2019/4/19 15:44
 * 描述：
 */
public class Demo010_MyList1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        MyList myList = new MyList(list);

        List<Integer> newList = myList.map(new MapOperator() {
            @Override
            public int map(int x) {
                return x + 5;
            }
        });

        for(Integer i:  newList){
            System.out.println(i);
        }

    }
}


class MyList{

    private List<Integer> list = null;

    public MyList(List<Integer> list){
        this.list = list;
    }
    public void setList(List<Integer> list){
        this.list = list;
    }


    public List<Integer> map(MapOperator mapOperator){
        List<Integer> resultList = new ArrayList<Integer>();
        for(int n: list){
            int newN = mapOperator.map(n);
            resultList.add(newN);
        }
        return resultList;
    }

    public int reduce(ReduceOperator reduceOperator){

        // 自己实现
        return 0;
    }
}

interface MapOperator{
    int map(int x);
}

interface ReduceOperator{
    int reduce(int x, int y);
}