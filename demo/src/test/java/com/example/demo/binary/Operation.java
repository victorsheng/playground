package com.example.demo.binary;

public class Operation {

    static int OP_READ = 1 << 0;
    static int OP_WRITE = 1 << 2;
    static int OP_CONNECT = 1 << 3;
    static int OP_ACCEPT = 1 << 4;

    public static void main(String[] args) {
        System.out.println(OP_READ);
        System.out.println(OP_WRITE);
        System.out.println(OP_CONNECT);
        System.out.println(OP_ACCEPT);
    }
}
