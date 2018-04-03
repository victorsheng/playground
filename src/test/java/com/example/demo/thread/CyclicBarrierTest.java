package com.example.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {


    public static void main(String[] args) {
        // CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("所有玩家进入第二关！");
                    }
                });

        for (int i = 0; i < 4; i++) {
            new Thread(new Player(i, cyclicBarrier)).start();
        }
    }
}


class Player implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int id;

    public Player(int id, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("玩家" + id + "正在玩第一关...");
            cyclicBarrier.await();
            System.out.println("玩家" + id + "进入第二关...");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}