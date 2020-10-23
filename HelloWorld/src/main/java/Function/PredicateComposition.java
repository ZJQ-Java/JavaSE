package Function;

import java.util.function.Predicate;

public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2);
//    public static void main(String[] args) {
//        Stream.of("bar", "foobar", "foobaz", "fongopuckey")
//                .filter(p4)
//                .forEach(System.out::println);
//        HashSet<Integer> set = new HashSet<>(3,1f);
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        System.out.println();
//    }

    public static void main(String[] args) {
        /*int aHundredMillion = 100000;
        Map<Integer, Integer> map1 = new HashMap<>(aHundredMillion);

        long s5 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }
        long s6 = System.currentTimeMillis();

        System.out.println("初始化容量5000000，耗时 ： " + (s6 - s5));


        Map<Integer, Integer> map = new HashMap<>(aHundredMillion +1  ,1f);

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long s2 = System.currentTimeMillis();

        System.out.println("+1 size，耗时 ： " + (s2 - s1));


        Map<Integer, Integer> map2 = new HashMap<>(aHundredMillion,1f);

        long s3 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s4 = System.currentTimeMillis();

        System.out.println("初始化容量为10000000，耗时 ： " + (s4 - s3));*/





    }
}
