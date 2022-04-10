package ThreadTest;

/**
 * Date:     2019/3/4 16:21
 */
public class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;


    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            int j;
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);

        }
        thread.start(); //真正开启了新线程
    }

    public static void main(String[] args) {
        ThreadDemo T1 = new ThreadDemo("Thread1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread1");
        T2.start();
    }
}
