package com.example.demo.sort.merge;

import java.util.Arrays;

public class MyMergeSort {

    public static void main(String[] args) throws Exception {
        int[] ints = {5, 3, 9, 1, 6, 7, 2, 4, 0, 8};
        new MyMergeSort().mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void internalMergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + right / 2;
            internalMergeSort(arr, temp, left, mid);
            internalMergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }

    }


}
