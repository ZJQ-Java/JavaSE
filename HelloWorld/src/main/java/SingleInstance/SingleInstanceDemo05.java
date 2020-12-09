package SingleInstance;

public class SingleInstanceDemo05 {
    //懒汉 线程安全
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static SingleInstanceDemo05 instance = new SingleInstanceDemo05();
    }

    private SingleInstanceDemo05 instance;

    private SingleInstanceDemo05() {
    }

    public SingleInstanceDemo05 getInstance() {
        return SingletonHolder.instance;
    }
}
