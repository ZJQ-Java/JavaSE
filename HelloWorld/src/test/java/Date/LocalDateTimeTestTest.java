package Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalDateTimeTestTest {
    @Before
    public void before() {
        System.out.println("----------begin---------");
    }

    @After
    public void after() {
        System.out.println("----------after---------");
    }
    /*@ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 100 })
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }*/

    @Test
    public void testBetween() {
        /*LocalTime localTime = LocalTime.of(15,0);
        LocalTime comparatorTime = LocalTime.of(18,0);
        Duration between = Duration.    between(localTime, comparatorTime);
        System.out.println(between.getSeconds());*/
//        System.out.println(TimeUnit.DAYS.toMinutes(1));

//        System.out.println(JSON.toJSONString(between));

        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 1, 3));
        list.sort((o1, o2) -> {
            return o2 - o1;
        });
        list.stream().sorted();
        System.out.println(list);
    }
}