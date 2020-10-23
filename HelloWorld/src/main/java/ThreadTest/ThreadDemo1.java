package ThreadTest;

public class ThreadDemo1 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            Thread t = new testThread();
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            t.interrupt();
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("my Runnable");
        }
    }

    public static class testThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted()) {
                System.out.println((i++) + ":" + "hello");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("-----main begin --------------");
        //方式一
        try {
            Thread t = new MyThread();
            t.start();
            Thread.sleep(1);
            t.interrupt();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----main end ------------");

    }

}
