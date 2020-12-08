package SingleInstance;

public class SingleInstanceDemo02 {
    //懒汉  线程安全
    private SingleInstanceDemo02 instance;

    private SingleInstanceDemo02() {
    }

    //synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
    public synchronized SingleInstanceDemo02 getInstance() {
        if (instance == null) {
            instance = new SingleInstanceDemo02();
        }
        return instance;
    }
}
