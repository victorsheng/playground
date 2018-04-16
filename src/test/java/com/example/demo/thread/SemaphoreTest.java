package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();//使用并发库，创建缓存的线程池
        final Semaphore sp = new Semaphore(3);//创建一个Semaphore信号量，并设置最大并发数为3

        //availablePermits() //用来获取当前可用的访问次数
        System.out.println("初始化：当前有" + (3 - sp.availablePermits() + "个并发"));

        //创建10个任务，上面的缓存线程池就会创建10个对应的线程去执行
        for (int index = 0; index < 10; index++) {
            final int NO = index;  //记录第几个任务
            Runnable run = new Runnable() {  //具体任务
                public void run() {
                    try {
                        sp.acquire();  // 获取许可
                        System.out.println(Thread.currentThread().getName()
                                + "获取许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
                        Thread.sleep(1000);
                        // 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
                        sp.release();  //释放许可
                        System.out.println(Thread.currentThread().getName()
                                + "释放许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
                    } catch (InterruptedException e) {
                    }
                }
            };
            service.execute(run);  //执行任务
        }
        service.shutdown(); //关闭线程池
    }
}
