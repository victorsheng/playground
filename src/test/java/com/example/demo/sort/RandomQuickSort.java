package com.example.demo.sort;

import java.util.Random;

public class RandomQuickSort {

    Random random = new Random();

    //快速排序的随机化版本，除了调用划分函数不同，和之前快排的代码结构一模一样
    public void RandomQuickSort(int[] a, int left, int right) {
        if (left < right) {
            int p = randomPartition(a, left, right);
            RandomQuickSort(a, left, p - 1);
            RandomQuickSort(a, p + 1, right);
        }
    }

    //随机化划分
    public  int randomPartition(int[] a, int left, int right) {
        int r = random.nextInt(right - left) + left; //生成一个随机数，即是主元所在位置
        swap(a, right, r); //将主元与序列最右边元素互换位置，这样就变成了之前快排的形式。
        return partition(a, left, right); //直接调用之前的代码
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        // 坑位
        int index = pivot + 1;

        //遍历,从index开始
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                //跟pivot比较,但是跟index进行比较
                swap(arr, i, index);
                index++;
            }
        }
        //交换
        swap(arr, pivot, index - 1);
        //返回坑位
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        System.out.println("swap" + i + "----" + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
