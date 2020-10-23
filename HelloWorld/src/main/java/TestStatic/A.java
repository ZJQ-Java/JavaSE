package TestStatic;

/**
 * Date:     2019/1/24 10:53
 */
class A extends AFather{
    public static int index = 100;
    static{
        System.out.println("A的静态代码块");
        index = 500;
    }
    public A(){
        System.out.println("A的构造函数");
    }
}
