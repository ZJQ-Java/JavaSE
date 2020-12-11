package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    public AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> mylock");
        // 自旋锁
        while (!atomicReference.compareAndSet(null, thread)) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(thread.getName() + "--------");
        }
    }

    // 解锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myUnlock");
        atomicReference.compareAndSet(thread, null);
    }

}
