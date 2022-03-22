package day4.scala.actor;

import java.util.concurrent.*;

/**
 * 作者： 马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2017/7/7 15:58
 * 描述：
 */
public class FutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在查找数据");
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " 数据查找完毕");
                return 9527;
            }
        });

        System.out.println(Thread.currentThread().getName() + " " + future.isDone());
//        System.out.println(future.get(5000, TimeUnit.MILLISECONDS));
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName() + " " + future.isDone());
        System.out.println(future.get());
    }

}
