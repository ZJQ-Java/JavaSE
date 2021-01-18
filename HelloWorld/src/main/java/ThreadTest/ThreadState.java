package ThreadTest;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("----------------");
        });

        Thread.State state = t.getState();
        System.out.println(state); //new

        t.start();
        System.out.println(t.getState()); //runable


        Thread.State state1 = t.getState();
        while (state1 != Thread.State.TERMINATED) {
            Thread.sleep(1000);
            System.out.println(t.getState());
            state1 = t.getState();
        }
        System.out.println(state1);
    }
}
