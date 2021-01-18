package TestStatic;

/**
 * Date:     2019/1/24 10:53
 */
class AFather {
    static {
        System.out.println("AFather的静态代码块");
    }

    public AFather() {
        System.out.println("AFather的构造函数");
    }
}
