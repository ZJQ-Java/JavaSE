package SingleInstance;

public class SingleInstanceDemo01 {
    //懒汉 非线程安全
    private static SingleInstanceDemo01 instance;

    private SingleInstanceDemo01() {
    }

    public static SingleInstanceDemo01 getInstance() {
        if (instance == null) {
            instance = new SingleInstanceDemo01();
        }
        return instance;
    }
}
