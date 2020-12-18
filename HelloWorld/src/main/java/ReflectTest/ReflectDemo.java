package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    private int    id;
    private String name;
    public  int    age;

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
        System.out.println("------------");
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
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("ReflectTest.ReflectDemo");
        String name = aClass.getName();
        System.out.println("name:" + name);
        String simpleName = aClass.getSimpleName();
        System.out.println("simpleName :" + simpleName);
        System.out.println("==============field====================");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("field :" + field);
        }

        System.out.println("==============getDeclaredFields====================");
        fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field :" + field);
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
        ReflectDemo o = (ReflectDemo) constructor.newInstance();
        System.out.println(o);
    }
}