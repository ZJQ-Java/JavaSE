package ThreadTest;

public class ThreadVolatile {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(10);
        t.flag = true;
        System.out.println("--------------");
    }

    public static class HelloThread extends Thread {
        public volatile boolean flag = false;

        @Override
        public void run() {
            int i = 0;
            while (!flag) {
                try {
                    System.out.println((i++) + "hello");
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
