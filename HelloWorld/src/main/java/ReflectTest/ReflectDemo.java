package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    private int    id;
    private String name;
    private int    age;

    private ReflectDemo() {
    }

    public ReflectDemo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void test() {
        System.out.println("-----test-------");
    }

    @Override
    public String toString() {
        return "ReflectDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args)
            throws Exception {

        Class<?> aClass = Class.forName("ReflectTest.ReflectDemo");
        String name = aClass.getName();
        System.out.println("fieldName:" + name);
        String simpleName = aClass.getSimpleName();
        System.out.println("simpleName :" + simpleName);
        System.out.println("==============fieldName====================");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("fieldName :" + field);
        }

        System.out.println("==============getDeclaredFields====================");
        fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("fieldName :" + field);
        }

        System.out.println("==============method====================");
        Method method = aClass.getMethod("setAge", int.class);
        System.out.println("method:" + method);
        method = aClass.getDeclaredMethod("test", null);
        System.out.println("private method:" + method);

        System.out.println("==============construct================");
//        ReflectDemo o = (ReflectDemo)aClass.newInstance();
//        System.out.println(o);
        //支持private
        Constructor<?> constructor = aClass.getDeclaredConstructor(null);
        System.out.println("constructor:" + constructor);
        //only public
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor1 : constructors) {
            System.out.println("constructors:" + constructor1);
        }
        //=================invoke==================
        System.out.println("=================invoke==================");
        constructor.setAccessible(true);
        ReflectDemo o = (ReflectDemo) constructor.newInstance();
        System.out.println(o);
        Method setAge = aClass.getDeclaredMethod("setAge", int.class);
        setAge.invoke(o, 18);
        System.out.println(o);

        System.out.println();
        //setAccessible
        System.out.println("=============setAccessible 外部使用的时需要设置===================");
        Field fieldName = aClass.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(o, "hahaha1");
        System.out.println(fieldName.get(o));


        //---------------------
        Method test = aClass.getDeclaredMethod("test", null);
        test.setAccessible(true);
        test.invoke(o, null);


        for (Field _filed : aClass.getDeclaredFields()) {
            _filed.setAccessible(true);
            System.out.println(_filed.get(o));
        }
    }
}