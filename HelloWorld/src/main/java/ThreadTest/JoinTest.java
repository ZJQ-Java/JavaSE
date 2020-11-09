package ThreadTest;

//插队
public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run.." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinTest());
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 200) {

                thread.join();
            }
            System.out.println("main..." + i);
        }
    }
}
