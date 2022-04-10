package SingleInstance;

import java.lang.reflect.Constructor;

public class SingleInstanceDemo03 {
    //懒汉  线程安全 使用volatile 禁止指令重排
    //（1）分配内存空间。
    //（2）将内存空间的地址赋值给对应的引用。
    //（3）初始化对象
    private static volatile SingleInstanceDemo03 instance;
    private static          boolean              flag = false;

    //实例必须有 volatile 关键字修饰，其保证初始化完全。
    private SingleInstanceDemo03() throws Exception {
        if (!flag) {
            flag = true;
        } else {
            throw new Exception("不要重复创建对象");
        }
        if (instance != null) {
            throw new Exception("不要重复创建对象");
        }
    }

    //synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
    public static SingleInstanceDemo03 getInstance() throws Exception {
        if (instance == null) {
            synchronized (SingleInstanceDemo03.class) {
                if (instance == null) {
                    //1.分配内存空间
                    //2.new对象
                    //3.对象赋值
                    instance = new SingleInstanceDemo03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        /*CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----------");
                SingleInstanceDemo03.getInstance().hashCode();
            }).start();
        }
        Thread.sleep(2000);
        countDownLatch.countDown();*/


        Constructor<SingleInstanceDemo03> constructor = SingleInstanceDemo03.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingleInstanceDemo03 singleInstanceDemo04 = constructor.newInstance();
        System.out.println(singleInstanceDemo04);

//        Field flag = SingleInstanceDemo03.class.getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.setBoolean("flag", false);
        SingleInstanceDemo03 instance = SingleInstanceDemo03.getInstance();
        System.out.println(instance);
    }
}
