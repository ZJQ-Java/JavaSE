package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {
    long start;
    long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;

    }

    @Override
    protected Long compute() {
        long result = 0;
        if (end - start <= 10000) {
            for (long i = start; i <= end; i++) {
                result += i;
            }
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo forkJoinDemo = new ForkJoinDemo(start, middle);
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(middle + 1, end);
            ForkJoinTask<Long> fork = forkJoinDemo.fork();
            ForkJoinTask<Long> fork1 = forkJoinDemo1.fork();
            try {
                result = fork.get() + fork1.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    public static Long test() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinDemo(0L, 100_000_0000);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinTask);
        return submit.get();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Long sum = 0L;
//        for (int i = 0; i <= 100_000_0000; i++) {
//            sum += i;
//        }
        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime  +"  sum=" + sum);
//
//        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, 100_000_0000);
//        startTime = System.currentTimeMillis();
//        sum = 0L;
//        sum = forkJoinDemo.compute();
//        endTime = System.currentTimeMillis();
//
//        System.out.println(endTime - startTime +"  sum=" + sum);
//
//        sum = 0L;
//        startTime = System.currentTimeMillis();
//        sum = LongStream.rangeClosed(0, 100_000_0000).parallel().sum();
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime +"  sum=" + sum);

        sum = 0L;
        startTime = System.currentTimeMillis();
        sum = ForkJoinDemo.test();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "  sum=" + sum);
        /*User u1 = new User(1, 21, "a");
        User u2 = new User(2, 22, "b");
        User u3 = new User(3, 23, "c");
        User u4 = new User(4, 24, "d");
        User u5 = new User(6, 25, "e");
        // 集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        // 计算交给Stream流
        // lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream()
                .filter(u -> { return u.getId() % 2 == 0; })
                .filter(u -> { return u.getAge() > 23; })
                .map(u -> { return u.getName().toUpperCase(); })
                .sorted((uu1, uu2) -> { return uu2.compareTo(uu1); })
                .limit(1)
                .forEach(System.out::println);*/

    }
}
