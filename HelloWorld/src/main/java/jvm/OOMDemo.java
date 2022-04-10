package jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMDemo {
    public static void main(String[] args) {
        try {
            //电脑死机
            test01();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    //JAVA堆异常溢出
    //Exception in thread "Thread-160217" Exception in thread "Thread-160218" java.lang.OutOfMemoryError: Java heap space
    public static void test01() {
        ClassLoaderDemo classLoaderDemo = null;
        System.out.println(Runtime.getRuntime().maxMemory());
        try {
            List<ClassLoaderDemo> list = new ArrayList<>();
            while (true) {
                new Thread(() -> {
                    list.add(new ClassLoaderDemo());
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    //JAVA 栈最大深度
    public static void test02() {
        //Exception in thread "main" java.lang.StackOverflowError
        stackLength();
    }

    private static int stackLength = 1;

    public static void stackLength() {
        stackLength++;
        stackLength();
    }

    public static void test03() {
        while (true) {

        }
    }

    public static void stackLeakByThread() {
        while (true) {
            new Thread(OOMDemo::test03).start();
        }
    }


}
