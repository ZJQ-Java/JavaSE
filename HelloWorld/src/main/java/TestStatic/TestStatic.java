package TestStatic;

/**
 * Date:     2019/1/22 19:58
 */
public class TestStatic {
    public static void main(String[] args) {
        A a = new A();     //都是先加载静态代码块，然后再加载构造函数。


        //获得加载器
//            System.out.println(ClassLoader.getSystemClassLoader());
//            //获得父类加载器
//            System.out.println(ClassLoader.getSystemClassLoader().getParent());
//            //获得父类加载器的父类  null底层看不到效果
//            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
//
//
//            Random random = new Random();
//            int index = random.nextInt(2);
//
//            System.out.println(index);


    }
}
