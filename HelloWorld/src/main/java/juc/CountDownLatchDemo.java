package juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(3);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                c.countDown();
            }, String.valueOf(i)).start();
        }
        c.await();
        System.out.println(c.getCount());

        System.out.println("1111111111111");
    }
}
