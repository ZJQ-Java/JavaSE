package ThreadTest;

import org.junit.Test;

public class ThreadDemo1Test {
    @Test
    public void myThreadTest() {
        //方式二
        System.out.println("--------myThreadTest begin--------");
        Thread t = new ThreadDemo1.MyThread();
        t.start();
        System.out.println("--------myThreadTest end--------");
    }

    @Test
    public void myRunnableTest() {
        //方式三
        System.out.println("--------myRunnableTest begin--------");
        Thread t = new Thread(new ThreadDemo1.MyRunnable());
        t.start();
        System.out.println("--------myRunnableTest end--------");
    }

}