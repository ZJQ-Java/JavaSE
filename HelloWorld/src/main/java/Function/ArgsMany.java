package Function;

import java.util.ArrayList;
import java.util.List;

public class ArgsMany {
    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
//    public static class TriFunctionTest {
//        static int f(int i, long l, double d) { return 99; }
//    }

    public static void main(String[] args) {
//        TriFunction<Integer, Long, Double, String> tf;
//        tf = (i, l, d) -> {
//            return i + l + d + "";
//        };
//        System.out.println(tf.apply(2, 1L, 2.1));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.stream().noneMatch(o -> o.equals(5)));
    }
}
