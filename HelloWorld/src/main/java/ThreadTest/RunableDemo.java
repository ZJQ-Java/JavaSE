package ThreadTest;

/**
 * Date:     2019/3/4 16:23
 */
public class RunableDemo implements Runnable{
    private Thread t;
    private String threadName;

    RunableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }
    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    public void start () {    //启动一个新的线程
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
    public static void main(String args[]) {
        RunableDemo R1 = new RunableDemo( "Thread-1");
//        R1.start();
        new Thread(R1).start();

        RunableDemo R2 = new RunableDemo( "Thread-2");
        R2.start();
    }
}
