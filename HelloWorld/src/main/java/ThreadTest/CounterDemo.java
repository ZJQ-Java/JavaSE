package ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CounterDemo {
    public static ReentrantLock lock = new ReentrantLock();

    public int add(int i) throws InterruptedException {
        int result = 0;
        //可以尝试获取锁，并有时间限制，不会死锁
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                lock.lock();
                result = ++i;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return result;
    }
    public synchronized int del(int i){
        return --i;
    }
}
