package com.example.demo.interview;

import java.util.Arrays;

public class Sort0 {


    public static void main(String[] args) {
        int[] ints = {7, 5, 3, 123, 22, 52, 3, 3, 2, 3, 3, 3, 4, 7, 1, 10};
        MergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }


    public static void MergeSort(int[] arr, int low, int high) {
        //使用递归的方式进行归并排序，所需要的空间复杂度是O（N+logN）
        int mid = (low + high) / 2;
        if (low < high) {
            //递归地对左右两边进行排序
            MergeSort(arr, low, mid);
            MergeSort(arr, mid + 1, high);
            //合并
            merge(arr, low, mid, high);
        }
    }

    /**
     * /**
     * 将数组中low到high位置的数进行排序
     *
     * @param arr  待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }

}
