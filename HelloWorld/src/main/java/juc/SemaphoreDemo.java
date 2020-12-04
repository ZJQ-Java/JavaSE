package juc;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore =  new Semaphore(3);

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();  //permits不足等待
                    System.out.println(Thread.currentThread().getName() + "：停车");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName() + "：开走");

                    semaphore.release();  //释放信号量
                }
            },String.valueOf(i)).start();

        }
    }
}
