package day1.core;

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2019/4/20 17:52
 * 描述：
 */
public class Test1 {

    public static void main(String[] args) {

        int j = 0;
        for (; j < 100; j++) {
            j = j++;
            System.out.println(j);
        }
        System.out.print(j);
    }
}
