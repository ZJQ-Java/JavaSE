package juc;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ExecutorService thread = new ThreadPoolExecutor(1,
                3,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        //i=4 一个线程
        //i>4 超过1+3，3个线程
        //i=6 3个线程
        //i>6 ThreadPoolExecutor.AbortPolicy()抛出异常
        //i>6 ThreadPoolExecutor.CallerRunsPolicy() 主线程执行
        //i>6 ThreadPoolExecutor.DiscardPolicy()不处理
        //i>6 ThreadPoolExecutor.DiscardOldestPolicy()抢占第一个线程

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            thread.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " i=" + finalI);
            });
        }
        thread.shutdown();

    }
}
