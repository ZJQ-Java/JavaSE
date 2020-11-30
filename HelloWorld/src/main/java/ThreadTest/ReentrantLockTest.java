package ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockThread thread = new ReentrantLockThread();

        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();

//        Thread.sleep(3000);
    }
}

class ReentrantLockThread implements Runnable {
    ReentrantLock lock        = new ReentrantLock();
    int           ticketCount = 10;

    @Override
    public void run() {
           /*synchronized (this){
               while(true){
                   if (ticketCount > 0) {
                       try {
                           Thread.sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println(ticketCount--);
                   }else{
                       return;
                   }

               }
           }*/
        try {
            lock.lock();
            while (true) {
                if (ticketCount > 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketCount--);
                } else {
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
