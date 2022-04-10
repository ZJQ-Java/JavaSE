package juc;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    public static volatile AtomicInteger num = new AtomicInteger(0);

    //    volatile
    //可见性
    //不保证原子性
    //禁止指令重排
    //可见性
    public static void Visibility() throws InterruptedException {
        new Thread(() -> {
            while (num.equals(0)) {

            }
        }).start();
        Thread.sleep(2000);
        num.set(1);
        System.out.println("---------------");
    }

    //不保证原子性Atomicity
    public static void add() {
        num.incrementAndGet();
//        num++;
    }

    public static void unAtomicity() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
