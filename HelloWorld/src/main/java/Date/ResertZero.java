package Date;

import java.util.Calendar;
import java.util.Date;

/**
 * Date:     2019/2/21 17:41
 */
public class ResertZero {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
// 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime());
    }
}
