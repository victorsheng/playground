package com.example.demo;

/**
 * 回形矩阵打印
 */
public class JuZhenDayin {

    static class Node {

        private int current = 0;

        int getNext() {
            current++;
            return current;

        }
    }

    static class Node2 {

        private int current = 0;

        private boolean increament = true;

        int getNext() {

            if (increament) {
                current++;

                if (current == 10) {
                    increament = false;
                }

            } else {
                current--;

                if (current == 1) {
                    increament = true;
                }
            }

            return current;

        }
    }

    public static void main(String[] args) {
        print(10);
    }

    private static void print(int target) {
        Node2 node = new Node2();

        int[][] reuslt = new int[target][target];
        int len = target;

        int top = 0;
        int bottOn = target - 1;
        int left = 0;
        int rigth = target - 1;

        while (len > 0) {
            for (int j = left; j <= rigth; j++) {
                reuslt[top][j] = node.getNext();
            }
            top++;
            for (int j = top; j <= bottOn; j++) {
                reuslt[j][rigth] = node.getNext();
            }

            rigth--;
            for (int j = rigth; j >= left; j--) {
                reuslt[bottOn][j] = node.getNext();
            }
            bottOn--;
            for (int j = bottOn; j >= top; j--) {
                reuslt[j][left] = node.getNext();
            }
            left++;
            len--;
        }

        for (int j = 0; j < target; j++) {
            for (int k = 0; k < target; k++) {
                System.out.print(" " + reuslt[j][k]);
            }
            System.out.println(" ");
        }

    }
}
