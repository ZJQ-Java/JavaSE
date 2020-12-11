package juc.lock;

import java.util.concurrent.TimeUnit;

public class SpinLockDemo {
    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        new Thread(()-> {
            try {
                lock.myLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()-> {
            try {
                lock.myLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"T2").start();
    }
}
