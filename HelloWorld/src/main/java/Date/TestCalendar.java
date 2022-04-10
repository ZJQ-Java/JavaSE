package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date:     2019/1/21 15:13
 */
public class TestCalendar {
    public static void main(String[] args) {
        int amInt = Calendar.AM;
        int pmInt = Calendar.PM;

        //第一种获得Calendar对象的方法。
        Calendar calendar = new GregorianCalendar();
        //第二种
        Calendar calendar1 = Calendar.getInstance();
        //设置年月日时分秒
        calendar.set(2019, Calendar.JANUARY, 21, 15, 30, 50);
        Date date = calendar.getTime();
        System.out.println(date);
        //通过set方法分别塞年月日
        calendar1.set(Calendar.YEAR, 2019);
        calendar1.set(Calendar.MONTH, 2);
        calendar1.set(Calendar.DATE, 10);
        Date date1 = calendar1.getTime();
        System.out.println("date1:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1));
        //可以通过setTime方法设置时间
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(new Date());
        System.out.println("setTime:" + calendar2.getTime());

        calendar2.add(Calendar.DATE, -7);
        System.out.println(calendar2.getTime());

//        可以通过API进行加减日期
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.YEAR, 10);
        calendar3.add(Calendar.YEAR, -20);
        calendar3.add(Calendar.MONTH, 10);
        calendar3.add(Calendar.DATE, 1);
        System.out.println("add:" + calendar3.getTime());


    }
}
