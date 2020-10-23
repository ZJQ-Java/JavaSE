package ReflectTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class getGenericSuperclass<T> {
    public T type;
    public T age;

    public getGenericSuperclass() {
    }

    public getGenericSuperclass(T type, T age) {
        this.type = type;
        this.age = age;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    static class Sub extends getGenericSuperclass<Integer> {
        public Sub(int type, int age) {
            super(type, age);
        }
    }

    public static void main(String[] args) {
        /*Class<Sub> subClass = Sub.class;
        Type genericSuperclass = subClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
        if (genericSuperclass instanceof ParameterizedType) {
            String typeName = genericSuperclass.getTypeName();
            System.out.println(typeName);
            ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            Class<?> actualTypeArgument1 = (Class<?>) actualTypeArgument;
            System.out.println(actualTypeArgument1.getTypeName());
        }*/
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 3, 5));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        int asc = 1;
        list.sort((o1, o2) -> {
            return Integer.compare(o1, o2) * asc;
        });
        System.out.println(list);
    }
}

