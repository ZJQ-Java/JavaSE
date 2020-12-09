package ThreadTest;

public class DeadLock {

    public static void main(String[] args) {
        TestDeadLockThread t = new TestDeadLockThread(1);
        TestDeadLockThread t1 = new TestDeadLockThread(0);
        t.start();
        t1.start();
    }

}

class A {

}

class B {

}

class TestDeadLockThread extends Thread {
    static A a = new A();
    static B b = new B();
    int choice;

    public TestDeadLockThread(int choice) {
        this.choice = choice;
    }

    @Override
    public void run() {
        if (choice == 0) {
            synchronized (a) {
                System.out.println("aaaaa");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("bbbbbbbb");
                }
            }
            /*synchronized (b) {
                System.out.println("bbbbbbbb");
            }*/
        } else {
            synchronized (b) {
                System.out.println("----------choice2-bbb----------");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("----------choice2-aaa----------");
                }
            }
            /*synchronized (a) {
                System.out.println("----------choice2-aaa----------");
            }*/
        }

    }
}
