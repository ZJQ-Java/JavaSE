package Function;

import java.util.function.Function;

public class ComposeAndThen {
    //compose 作用在f1前执行
    //f1.compose(f2) == f2.andThen(f1);
    public static class FunctionComposition {
        static Function<String, String> f1 = s -> {
            System.out.println(s);
            return s.replace('A', '_');
        },
                f2                         = s -> s.substring(3),
                f3                         = s -> s.toLowerCase(),
                f4                         = f1.compose(f2).andThen(f3),
                f5                         = f2.andThen(f1).andThen(f3);

        public static void main(String[] args) {
            System.out.println(
                    f4.apply("GO AFTER ALL AMBULANCES"));
            System.out.println(
                    f5.apply("GO AFTER ALL AMBULANCES"));
        }
    }
}
