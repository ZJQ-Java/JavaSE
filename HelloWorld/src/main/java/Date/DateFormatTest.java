package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date:     2019/1/21 15:04
 */
public class DateFormatTest {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //错误的测试，月的MM，分是mm，不要写反
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy年mm月dd日 HH:MM:ss");
        Date date = new Date();
        String dateStr = dateFormat1.format(date);
        System.out.println(dateStr);

        String str = "2019年01月21日 15:09:10";
        Date date1 = null;
        try {
            date1 = dateFormat.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
