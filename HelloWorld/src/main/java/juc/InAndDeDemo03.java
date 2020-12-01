package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InAndDeDemo03 {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }


}

class Data3 {
    public       int           index      = 1;
    public       ReentrantLock lock       = new ReentrantLock();
    public final Condition     condition1 = lock.newCondition();
    public final Condition     condition2 = lock.newCondition();
    public final Condition     condition3 = lock.newCondition();

    void printA() throws InterruptedException {
        try {
            lock.lock();
            while (index != 1) {
                condition1.await();
            }
            index = 2;
            System.out.println("AAAAAAAAAAAAAA");
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    void printB() throws InterruptedException {
        try {
            lock.lock();
            while (index != 2) {
                condition2.await();
            }
            index = 3;
            System.out.println("BBBBBBBBBBBBBB");
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void printC() throws InterruptedException {
        try {
            lock.lock();
            while (index != 3) {
                condition3.await();
            }
            index = 1;
            System.out.println("CCCCCCCCCCCCCCCCCC");
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
