package ReflectTest;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectDemo {
    private int                 id;
    private String              name;
    private int                 age;
    private Map<String, String> map;

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

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> test01() {
        System.out.println("--------map-----------");
        return new HashMap<>();
    }

    public void test02(Map<String, Integer> map, List<ReflectDemo> list) {
        System.out.println("--------map-----------");
    }

    @Override
    public String toString() {
        return "ReflectDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
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

        //=============获得泛型=================
        System.out.println("=============获得泛型=================");
        Field fieldMap = aClass.getDeclaredField("map");
        System.out.println("fieldMap field : " + fieldMap);
        Class<?> type = fieldMap.getType();
        System.out.println(type);
        Map<String, String> m = new HashMap<>();
        m.put("1", "test1");
        fieldMap.set(o, m);
        System.out.println(o.getMap());
        /*  Type[] getActualTypeArguments()
             返回表示此类型实际类型参数的 Type对象的数组。
            Type getOwnerType()
             返回 Type 对象，表示此类型是其成员之一的类型。
            Type getRawType()
             返回 Type 对象，表示声明此类型的类或接口。
        */
        Type genericType = fieldMap.getGenericType();
        ParameterizedType pt = (ParameterizedType) genericType;
        System.out.println("ParameterizedType:" + pt);
        System.out.println("getActualTypeArguments:" + Arrays.toString(pt.getActualTypeArguments()));

        //=====================获取方法参数==================
        System.out.println("=====================获取方法参数==================");
        Method test02 = aClass.getDeclaredMethod("test02", Map.class, List.class);
        Type[] genericParameterTypes = test02.getGenericParameterTypes();
        for (Type parameterType : genericParameterTypes) {
            if (parameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) parameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        Method test01 = aClass.getDeclaredMethod("test01");
        Type genericReturnType = test01.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}