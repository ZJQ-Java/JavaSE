package ComparatorTest;

import java.util.*;

public class comparatorDemo {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("1", new ArrayList<>(Arrays.asList(3, 4, 2, 1)));
        map.put("2", new ArrayList<>(Arrays.asList(5, 7, 6, 1)));
        System.out.println(map);

    }
}
