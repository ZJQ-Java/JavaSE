package SingleInstance;

public class SingleInstanceDemo03 {
    //懒汉  线程安全
    private volatile SingleInstanceDemo03 instance;
    //实例必须有 volatile 关键字修饰，其保证初始化完全。
    private SingleInstanceDemo03() {
    }

    //synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
    public SingleInstanceDemo03 getInstance() {
        if (instance == null) {
            synchronized (SingleInstanceDemo03.class) {
                if (instance == null) {
                    instance = new SingleInstanceDemo03();
                }
            }
        }
        return instance;
    }
}
