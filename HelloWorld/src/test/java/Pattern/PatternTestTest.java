package Pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTestTest {
    @Test
    public void regexTest() {
        String str = "010-12345678,031-23124567,02-21345123";
        String regex = "\\d{0,3}-\\d{8}";
        for (String s : str.split(",")) {
            System.out.println(s.matches(regex));
        }
    }

    /*@ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 100 })
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }*/

    @Test
    public void regexTest1() {
//        String str = "010-12345678,031-23124567,02-21345123";
        Pattern pattern = Pattern.compile("([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
        Matcher matcher = pattern.matcher("15:55:53");
        if (matcher.matches()) {
            String group = matcher.group(0);
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            System.out.println("group:" + group + " group1：" + group1 + " group2：" + group2 + " group3:" + group3);

        }
    }

    @Test
    public void regexTest2() {
        //+? 非贪婪，尽可能少匹配
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }
    }

    @Test
    public void regexTest3() {
        // \w [0-9a-zA-Z]
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    @Test
    public void regexTest4() {
        //$1反向引用 匹配到的字符串
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }

}