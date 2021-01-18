package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskDemo f = new FutureTaskDemo();
        FutureTask task = new FutureTask(f);
        new Thread(task, "A").start();
        new Thread(task, "B").start(); //有缓存

        Integer o = (Integer) task.get();
        System.out.println(o);
    }


    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1;
    }
}
