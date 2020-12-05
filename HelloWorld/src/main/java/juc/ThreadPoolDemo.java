package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService thread = Executors.newCachedThreadPool();
//        ExecutorService thread = Executors.newSingleThreadExecutor();
        ExecutorService thread = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            thread.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " i=" + finalI);
            });
        }
        thread.shutdown();

    }
}
