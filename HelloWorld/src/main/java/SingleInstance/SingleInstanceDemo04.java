package SingleInstance;

public class SingleInstanceDemo04 {
    //懒汉 非线程安全
    private static SingleInstanceDemo04 instance = new SingleInstanceDemo04();

    private SingleInstanceDemo04() {
    }

    public static SingleInstanceDemo04 getInstance() {
        return instance;
    }
}
