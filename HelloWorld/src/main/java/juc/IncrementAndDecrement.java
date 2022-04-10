package juc;

public class IncrementAndDecrement {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }


}

class Data {
    public int index = 0;

    synchronized void increment() throws InterruptedException {
        while (index != 0) {  //if存在虚假唤醒
            this.wait();
        }
        ++index;

        System.out.println(Thread.currentThread().getName() + "->" + index);
        this.notifyAll();
    }

    synchronized void decrement() throws InterruptedException {
        while (index == 0) {
            this.wait();
        }
        --index;

        System.out.println(Thread.currentThread().getName() + "->" + index);
        this.notifyAll();
    }
}
