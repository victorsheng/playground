package com.example.demo.sort;

import java.util.Arrays;

public class MyInsertSort {

    public static void main(String[] args) {
        int[] intArray = {7, 5, 3, 123, 22, 52, 3, 3, 2, 3, 3, 3, 4, 7, 1, 10};
//        insertSort(intArray);
        selectSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    private static void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j - 1] > ints[j]) {
                    swap(ints, j - 1, j);
                } else {
                    break;
                }
            }
        }

    }

    private static void selectSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int min = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[min]) {
                    min = j;
                }
            }
            swap(ints, i, min);
        }

    }


    private static void mergeSort(int[] ints) {
        int unSortNumber = 0;
        int sortNumber = 0;
        for (int i = 0; i < ints.length; i++) {
            unSortNumber++;
            if (unSortNumber == 2) {
                if (ints[i] < ints[i - 1]) {
                    swap(ints, i, i - 1);
                }
            }
        }
    }

    private static void swap(int[] array, int oldIndex, int newIndex) {
        int tmp = array[oldIndex];
        array[oldIndex] = array[newIndex];
        array[newIndex] = tmp;
        return;
    }

}
