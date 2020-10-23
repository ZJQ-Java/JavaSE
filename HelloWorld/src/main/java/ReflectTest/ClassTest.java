package ReflectTest;


/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/10 15:35
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String input = "ReflectTest.User";

        Class strClazz = String.class;
        Class strClazz1 = input.getClass();
        Class strClazz2 = Class.forName("java.lang.String");
        System.out.println(strClazz.hashCode());  //todo String class 每次的HashCode都是一样的
        System.out.println(strClazz1.hashCode());
        System.out.println(strClazz2.hashCode());

        Class intClazz = int.class;
        System.out.println(intClazz.hashCode());
        Class doubleClas = double.class;
        System.out.println(doubleClas.hashCode());
    }
}
