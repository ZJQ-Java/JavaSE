package ThreadTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class TestConsumerAndProducer {
    public static void main(String[] args) throws InterruptedException {
        BufferChicken chicken = new BufferChicken();
        Consumer c = new Consumer(chicken);
        Producer producer = new Producer(chicken);
        producer.start();

        c.start();
    }
}

class Consumer extends Thread {
    BufferChicken bufferChicken;

    public Consumer(BufferChicken bufferChicken) {
        this.bufferChicken = bufferChicken;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken poll = null;
            try {
                poll = bufferChicken.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (poll != null) {
                System.out.println("吃鸡的个数为：" + poll.i);
            }
        }
    }
}

class Producer extends Thread {
    BufferChicken bufferChicken;

    public Producer(BufferChicken bufferChicken) {
        this.bufferChicken = bufferChicken;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                bufferChicken.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Chicken {
    public int i;

    public Chicken(int i) {
        this.i = i;
    }
}

class BufferChicken {
    Queue<Chicken> chicken = new ArrayDeque<>();

    public synchronized void push(Chicken chicken) throws InterruptedException {
        if (this.chicken.size() == 10) {

            //生产出后通知消费
            this.notifyAll();
            this.wait();
        }
        //通知消费
        this.chicken.add(chicken);
        this.notifyAll();
    }

    public synchronized Chicken pop() throws InterruptedException {
        if (chicken.size() == 0) {
            this.wait();
        }
        this.notifyAll();
        Thread.sleep(1000);
        return chicken.poll();
    }
}
