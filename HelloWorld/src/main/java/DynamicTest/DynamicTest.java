package DynamicTest;

import ReflectTest.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Date:     2019/1/10 16:03
 */
public class DynamicTest {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        String input = "ReflectTest.User";
        Class clazz = Class.forName(input);
        User user = (User) Class.forName(input).newInstance();   //要求无参构造器必须为public
        System.out.println(user);
        //获取对应的构造函数
        Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
        User user1 = (User) constructor.newInstance(1, 18, "小米");
        System.out.println(user1);
        //通过反射api调用普通方法
        User user2 = (User) clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.invoke(user2, "小米");
        System.out.println(user2);

        //反射操作属性  需要字段为public
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);  //不检查属性
        field.set(user2, "老白");
        System.out.println(user2);

        //使用setAccessible
        Constructor constructor1 = clazz.getDeclaredConstructor(null);
        User user3 = (User) constructor1.newInstance();
        System.out.println("user3: " + user3);


    }
}

