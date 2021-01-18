package HttpTest;

import java.util.List;
import java.util.function.Supplier;

public class ServletDemo {
    public static void main(String[] args) {
        /*AtomicReference<List<Integer>> list = new AtomicReference<>();
        int i = 1;
        if (i == 1) {
            function(() -> {
                List<Integer> objects = new ArrayList<>(Arrays.asList(1, 2, 34));
                list.set(objects);
                return objects;
            });
        }
        System.out.println(list.get().isEmpty());
        System.out.println(list.get());*/

    }

    public static void function(Supplier<List<Integer>> supplier) {
        System.out.println(supplier.get());
    }

}
