package com.example.demo.forkjoinpool;

import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1000).toArray();
        Calculator calculator = new MyCalculator();
        System.out.println(calculator.sumUp(numbers)); // 打印结果500500
    }
}