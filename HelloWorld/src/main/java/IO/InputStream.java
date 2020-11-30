package IO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:     2019/3/1 14:44
 */
class Test<T>{
    private  T age;
    Test(T age){
        this.age = age;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}
class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}
public class InputStream {
    public static void main(String args[]) throws IOException {
        // 使用 System.in 创建 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        System.out.println("Enter lines of text.");
//        System.out.println("Enter 'end' to quit.");
//        do {
//            str = br.readLine();
//            System.out.println(str);
//        } while (!str.equals("end"));
        Test<Integer> test = new Test<Integer>(1);
        Test<String> test1 = new Test<String>("String");

        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        System.out.println(generic);
        System.out.println(generic1);
        System.out.println(generic2);
        List list = new ArrayList();
        list.add(true);
        list.add("string");

        for (Object o : list) {
            System.out.println(o.getClass());
        }
    }

}
