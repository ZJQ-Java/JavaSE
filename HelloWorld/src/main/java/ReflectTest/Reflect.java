package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/10 15:01
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("ReflectTest.User");
        Class clazz1 = Class.forName("ReflectTest.User");
        System.out.println(clazz.hashCode()+"   "+clazz1.hashCode());


//        获取到类名  带路径
        String clazzName = clazz.getName();
        System.out.println("全路径名："+clazzName);
//                获取到类名
        String clazzName1 = clazz.getSimpleName();
        System.out.println("类："+clazzName1);
        //只获取到public属性
        System.out.println("只获取到public属性");
        Field[] field = clazz.getFields();
        for (Field field1 : field) {
            System.out.println(field1);
        }
        //获取到所有属性
        System.out.println("获取到所有属性");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field2 : fields) {
            System.out.println(field2);
        }
        //获取method 包括父类的
        System.out.println("获取method 包括父类的");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println("有jar包的"+method.getName());
        }
        //获取method User类中的
        System.out.println("获取method User类中的");
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
            System.out.println("自己类中的"+method.getName());
        }



        Method method = clazz.getDeclaredMethod("setName",String.class);
        Method method1 = clazz.getDeclaredMethod("getName",null);
        System.out.println(method +"    "+method1);
        //获取构造器
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (Constructor constructor1 : constructor) {
            System.out.println(constructor1);

        }
    }
}
