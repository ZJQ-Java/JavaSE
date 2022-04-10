package ThreadTest;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("========daemon==========");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //开启守护，自动结束
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("=========main============");
        }
    }
}
