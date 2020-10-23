package MyClassLoad;

public class ClassLoadTest {
    public static void main(String[] args) {


        /*
          file:/D:/Java%e5%ad%a6%e4%b9%a0/JavaSE/HelloWorld/target/classes/MyClassLoad/
          file:/D:/Java%e5%ad%a6%e4%b9%a0/JavaSE/HelloWorld/target/classes/

          sun.misc.Launcher$ExtClassLoader@2c7b84de
          file:/D:/Java%e5%ad%a6%e4%b9%a0/JavaSE/HelloWorld/target/classes/
          null
        */
        System.out.println(ClassLoadTest.class.getResource(""));
        System.out.println(ClassLoadTest.class.getResource("/"));
        System.out.println();
        System.out.println(ClassLoadTest.class.getClassLoader().getParent());
        System.out.println(ClassLoadTest.class.getClassLoader().getResource(""));
        System.out.println(ClassLoadTest.class.getClassLoader().getResource("/"));

    }
}
