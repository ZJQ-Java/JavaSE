package ThreadTest;

//礼让，看cpu心情
public class YieldTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----begin----");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "----end----");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new YieldTest(), "a");
        Thread t1 = new Thread(new YieldTest(), "b");
        t.start();
        t1.start();

    }
}
