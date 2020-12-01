package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InAndDeDemo02 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }


}

class Data2 {
    public int index = 0;
    public ReentrantLock lock = new ReentrantLock();
    public final Condition condition = lock.newCondition();

     void increment() throws InterruptedException {

        try {
            lock.lock();
            while (index != 0) {  //if存在虚假唤醒
                condition.await();
    //            this.wait();
            }
            ++index;
            System.out.println(Thread.currentThread().getName() + "->" + index);
//        this.notifyAll();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

     void decrement() throws InterruptedException {
        try {
            lock.lock();
            while (index == 0) {
                condition.await();
            }
            --index;

            System.out.println(Thread.currentThread().getName() + "->" + index);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
