package Date;

import java.time.LocalDate;

public class LocalTimeCompare {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDateTimeTest.yyyyMMddToLocalTime(20201230);
        System.out.println(now.equals(localDate));
    }
}
