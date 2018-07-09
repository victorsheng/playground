package com.example.demo.sort;

import java.util.Arrays;

/**
 *
 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。

 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */
public class MergeTwoArray {

    public static void main(String[] args) throws Exception {
//        int[] ints1 = {1, 10, 20, 30, 0, 0, 0};
        int[] ints1 = new int[10];
        ints1[0] = 1;
        ints1[1] = 2;
        ints1[2] = 3;
        ints1[3] = 9;
        ints1[4] = 100;
        int[] ints2 = {4, 23, 30};
        int[] result = merge(ints1, 5, ints2);
        System.out.println(Arrays.toString(result));
    }


    static int[] merge(int[] ints1, int useLength, int[] ints2) {
        int length = ints2.length;
        int end = length + useLength - 1;
        int large = useLength - 1;
        int small = length - 1;
        while (large >= 0 && small >= 0) {
            int larger = 0;
            if (ints1[large] > ints2[small]) {
                larger = ints1[large];
                large--;
            } else {
                larger = ints2[small];
                small--;
            }
            ints1[end] = larger;
            end--;
        }


//        while (large > 0) {
//            ints1[total--] = ints1[large--];
//        }

        while (small == 0) {
            ints1[end--] = ints2[small--];
        }
        return ints1;
    }
}
