package DelayTest;

import java.util.concurrent.*;

public class DelayQueueDemo implements Delayed {
    private int    id;
    private String body;
    private long   time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //<=0 直接执行
        return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        DelayQueueDemo msg = (DelayQueueDemo) delayed;
        return Long.compare(this.time, msg.time);
    }

    public DelayQueueDemo(int id, String body,long delayTime) {
        this.id = id;
        this.body = body;
        this.time = TimeUnit.NANOSECONDS.convert(delayTime,TimeUnit.MILLISECONDS) + System.nanoTime();
    }
}

class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<DelayQueueDemo> queue;

    public Consumer(DelayQueue<DelayQueueDemo> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DelayQueueDemo take = queue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建延时队列
        DelayQueue<DelayQueueDemo> queue = new DelayQueue<DelayQueueDemo>();
        // 添加延时消息,m1 延时3s
        DelayQueueDemo m1 = new DelayQueueDemo(1, "world", 8000);
        // 添加延时消息,m2 延时10s
        DelayQueueDemo m2 = new DelayQueueDemo(2, "hello", 20000);
        DelayQueueDemo m3 = new DelayQueueDemo(0, "hello", 10000);
        //将延时消息放到延时队列中
        queue.offer(m2);
        queue.offer(m1);
        queue.offer(m3);
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        exec.shutdown();
    }
}
