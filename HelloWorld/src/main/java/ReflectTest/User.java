package ReflectTest;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/10 15:01
 */
public class User {
    public  int    id;
    private int    age;
    public  String name;

    public User() {
    }

    private User(int age) {
        this.age = age;
    }

    public User(int id, int age, String name) {

        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args)
            throws Exception {
        /*User user = new User();
        Class<User> userClass = User.class;
        Method getId = userClass.getDeclaredMethod("setAge", int.class);
        System.out.println(getId);*/

//        Method substring = String.class.getMethod("substring", int.class);
//        Method valueOf = String.class.getMethod("valueOf", int.class);
//        String hello = "hello World";
//        Object invoke = substring.invoke(hello, 1);
//        Object invoke1 = valueOf.invoke(null, 11111111);
//        System.out.println(invoke);
//        System.out.println(invoke1);
//        System.out.println(LocalDateTime.now());
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        System.out.println(LocalDateTime.now().getMinute());
//        System.out.println(LocalDateTime.now().getSecond());
//        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
//        System.out.println(dayOfWeek.getValue());
//        LocalTime localTime = LocalTime.of(now.getHour(), now.getMinute(), now.getSecond());
//        System.out.println(localTime);

        //系统加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //根加载器c++ 无法获得
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //同系统加载器
        ClassLoader classLoader = Class.forName("ReflectTest.User").getClassLoader();
        System.out.println(classLoader);
    }

}
class init{
    public init(){
        System.out.println("---------------init------------------");
    }
    public static int im = 1;
}
