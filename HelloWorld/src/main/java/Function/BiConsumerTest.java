package Function;

import Test.People;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BiConsumerTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(100, "三个人");
        map.put(110, "四个人");
        map.put(115, "五个人");
        map.put(120, "一群人");
        // 这个consumer 可以理解为一个函数，函数内容就是后面的lambda 表达式
        Consumer<Map> consumer = x -> {
            x.forEach((k, v) -> System.out.println("key:" + k + "value:" + v));
        };
//        consumer.accept(map);


        HashMap<Integer, String> mapMonkey = new HashMap<>();
        mapMonkey.put(200, "三只猴");
        mapMonkey.put(210, "四只猴");
        mapMonkey.put(215, "五只猴");
        mapMonkey.put(220, "一群猴");
        // BiConsumer 接受接受两个参数，一个是map，一个是 consumer
        BiConsumer<Map, Map> biConsumer = (map1, map2) -> map1.putAll(map2);
        biConsumer.accept(mapMonkey, map);
        consumer.accept(mapMonkey);
        List<People> list = new ArrayList<>();
        list.add(new People("mouse", "nose"));
        list.add(new People("mouse1", "nose1"));
        Stream<String> stringStream = list.stream().map(People::getMouse);
    }
}
