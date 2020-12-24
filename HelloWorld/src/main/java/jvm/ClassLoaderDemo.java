package jvm;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        /**
         * Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
         *
         * ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,
         * 只有在newInstance才会去执行static块。
         *
         * Class.forName(name,initialize,loader)带参函数也可控制是否加载static块。
         * 并且只有调用了newInstance()方法采用调用构造函数，创建类的对象
         */
//        Class c1 = Class.forName("jvm.Test");
//        System.out.println(c1);
//        ClassLoader classLoader = Test.class.getClassLoader();
//        Class c2 = classLoader.loadClass("jvm.Test");
//        System.out.println(c2);
//
//        Class c3 = Class.forName("jvm.Test", true, Test.class.getClassLoader());
//        System.out.println(c3);
        List<String> list = new ArrayList<>();
        list.add("2");
        List<Object> objects = Collections.singletonList(list);
        System.out.println(objects);
//        System.out.println(objects.isEmpty());
//        System.out.println(objects==null);
    }

}

class Test {
    static {
        System.out.println("加载test的静态方法");
    }
}
