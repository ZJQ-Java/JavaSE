package ThreadTest;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static final ExecutorService          fixPool             = Executors.newFixedThreadPool(5);//指定线程数量
    public static final ExecutorService          cachePool           = Executors.newCachedThreadPool(); // 动态的
    public static final ExecutorService          newCachePool        = new ThreadPoolExecutor(5, 10, 60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>()); // 5-10个
    public static final ExecutorService          singlePool          = Executors.newSingleThreadExecutor(); // 单线程池
    public static final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5); // 定时执行

    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 0; i < 8; i++) {
            fixPool.submit(new MyRunnablePool(i));
        }
        fixPool.shutdown();  //线程执行结束关闭
        fixPool.shutdownNow(); //立刻结束
        fixPool.awaitTermination(1, TimeUnit.SECONDS);// 等待timeout后结束

        //延迟initialDelay时间后执行，3秒执行一次，无论任务是否结束
        scheduledThreadPool.scheduleAtFixedRate(new MyRunnablePool(1), 0, 3, TimeUnit.SECONDS);

        //延迟initialDelay时间后执行，前任务执行完成后每3秒执行一次
        scheduledThreadPool.scheduleWithFixedDelay(new MyRunnablePool(1), 0, 3, TimeUnit.SECONDS);*/
        Future submit = fixPool.submit(new MyCallable());
        try {
            String s = (String) submit.get();
            /*String s = submit.get(1,TimeUnit.SECONDS);*/
            submit.cancel(true);
            submit.isDone();//是否完成
            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        fixPool.shutdown();
    }

    public static class MyRunnablePool implements Runnable {
        int i;

        public MyRunnablePool(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("runnable begin i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable end  i=" + i);
        }
    }

    public static class MyCallable<T> implements Callable<T> {

        @Override
        public T call() throws Exception {
            return (T) "abc";
        }
    }
}
