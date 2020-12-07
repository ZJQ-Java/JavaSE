package Function;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, String> function = str -> {
            return String.valueOf(++str);
        };
        String apply = function.apply(1);
        System.out.println(apply);
        Predicate<String> predicate = o -> {
            return o.equals("zjq");
        };
        boolean test = predicate.test("11");
        System.out.println(test);

        long sum = LongStream.range(1, 10).parallel().sum();
        System.out.println(sum);
    }
}
