package ThreadTest;

import java.util.concurrent.*;

/**
 * Date:     2019/3/4 17:14
 */
public class CallableDemo extends Thread{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建对象
        Race tortoise = new Race(1000,"tortoise");
        Race rabbit = new Race(500,"rabbit");
        //提交
        Future<Integer> result = executorService.submit(tortoise);
        Future<Integer> result1 = executorService.submit(rabbit);
        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);
        //获取值
        int num = result.get();
        int num1 = result1.get();
        System.out.println("乌龟跑了多少步"+num);
        System.out.println("兔子跑了多少步"+num1);
        //停止服务
        executorService.shutdown();
    }


}
class Race implements Callable<Integer> {
    private long time;
    private String name;
    private boolean flag = true;
    private Integer step = 0;

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Race(long time, String name) {
        this.time = time;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}
