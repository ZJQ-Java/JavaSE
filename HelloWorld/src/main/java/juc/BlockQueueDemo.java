package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueueDemo {
    public static ReentrantLock lock = new ReentrantLock();
    static Condition condition = BlockQueueDemo.lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        /*ArrayBlockingQueue bqueue = new ArrayBlockingQueue(1);
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    BlockQueueDemo.lock.lock();
                    boolean offer = bqueue.offer(finalI);
                    while (!offer) {
                        System.out.println(finalI +" offer is false");
                        condition.await();
                        offer = bqueue.offer(finalI);
                        System.out.println(finalI +" offer: " +offer);

                        condition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    BlockQueueDemo.lock.unlock();
                }

            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    BlockQueueDemo.lock.lock();
                    Object poll = bqueue.poll();
                    while (poll == null) {
                        condition.signal();
                        condition.await();
                        poll = bqueue.poll();
                    }
                    System.out.println("poll:" + poll);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    BlockQueueDemo.lock.unlock();
                }
            }, String.valueOf(i)).start();
        }*/
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // IllegalStateException: Queue full 抛出异常！
//         System.out.println(blockingQueue.add("d"));
        System.out.println("=-===========");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException 抛出异常！
//         System.out.println(blockingQueue.remove());
    }

    public static void test2() {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
         System.out.println(blockingQueue.offer("d")); // false 不抛出异常！
        System.out.println("============================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll()); // null 不抛出异常！

    }

    /**
     * 等待，阻塞（一直阻塞）
     */
    public static void test3() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //        SynchronousQueue 同步队列
        //        没有容量，
        //        进去一个元素，必须等待取出来之后，才能再往里面放一个元素！
        //        put、take
        // 一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//         blockingQueue.put("d"); // 队列没有位置了，一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println("--------------");
        System.out.println(blockingQueue.take()); // 没有这个元素，一直阻塞
    }

    /**
     * 等待，阻塞（等待超时）
     */
    public static void test4() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        new Thread(()->{
            System.out.println(blockingQueue.poll());
        }).start();
         blockingQueue.offer("d",2,TimeUnit.SECONDS); // 等待超过2秒就退出
        System.out.println("===============");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2, TimeUnit.SECONDS); // 等待超过2秒就退出
    }
}
