package ThreadTest;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

//使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，
// 这两种方法都不是很好，因为主线程也会被迫等待。
public class CompleteAbleFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> t = CompletableFuture.supplyAsync(CompleteAbleFutureDemo::getRandom);
        t.thenAccept(System.out::println);
        t.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        //可串行执行任务
        t.thenApplyAsync(CompleteAbleFutureDemo::add).thenAccept(System.out::println);

        System.out.println("----------------------");
        Thread.sleep(2000);
    }

    public static int getRandom() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random(47);
        int i = random.nextInt(50);
        if (i < 5) {
            throw new RuntimeException("i < 20");
        }
        return i;
    }

    public static int add(int i) {
        return i + 20;
    }
}
