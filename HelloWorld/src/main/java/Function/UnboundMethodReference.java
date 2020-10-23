package Function;

import java.util.function.Consumer;
import java.util.function.Predicate;

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

interface Callable { // [1]
    void call(String s);
}

class Describe {
    void show(String msg) { // [2]
        System.out.println(msg);
    }
}

public class UnboundMethodReference {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
//        TransformX sp = X::f;
//        X x = new X();
//        System.out.println(sp.transform(x)); // [2]
//        System.out.println(x.f()); // 同等效果
//        String str = "aaabbb";
//        System.out.println(str.substring(1));

//        Stream.of("bar", "foobar", "foobaz", "fongopuckey","aaa")
//                .filter(p4)
//                .forEach(System.out::println);
        // 使用Stream.generate()
//        Random seed = new Random();
//        Supplier<Integer> random = seed::nextInt;//使用方法引用的方式创建函数式接口引用的实例，等价于使用匿名内部类或Lambda表达式
//        Stream.generate(random).limit(10).forEach(System.out::println);
        //Collections.join
//        List<String> list = Arrays.asList("A", "B", "C");
//        System.out.println(list.stream().collect(Collectors.joining(",", "(", "]")));
        Callable callable = new Callable() {
            @Override
            public void call(String s) {

            }
        };
        Consumer<String> show = new Describe()::show;
        show.accept("111");
//        show.accept("s");
//        show.call("dddd");
    }
}
