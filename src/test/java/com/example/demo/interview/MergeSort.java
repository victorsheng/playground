package com.example.demo.interview;

import java.util.Scanner;

/**
 * 没太看懂
 */
@Deprecated
public class MergeSort {
    static int b[] = new int[100];//辅助数组，帮助合并

    public static void Merge(int a[], int low, int high, int mid) {
        int i, j, k;
        for (i = low; i <= high; i++) {
            b[i] = a[i];
        }
        //将mid前半部分和后半部分合并成一个有序表
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            //谁小要谁
            if (b[i] < b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }
        //两部分可能并不一样长，多余的直接赋值
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    public static void sort(int a[], int low, int high) {
        if (low < high) {
            //分治算法，划分成更小规模的左右有序表，两两合并
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            Merge(a, low, high, mid);
        }
    }

    public static void Print(int a[], int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String args[]) {
        int n;
        int a[];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            if (n > 0) {
                a = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    a[i] = scanner.nextInt();
                }
                sort(a, 1, n);
                Print(a, n);
            }
        }
        scanner.close();
    }
}

