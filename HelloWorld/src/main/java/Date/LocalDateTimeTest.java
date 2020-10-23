package Date;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        /*LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        LocalDateTime of = LocalDateTime.of(localDate, localTime);
        System.out.println(of);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format1 = format.format(localDateTime);
        System.out.println("=================");
        System.out.println(format1);
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        System.out.println("-----------------");
        System.out.println(format.format(localDateTime));
        //日期加减
        System.out.println("--------++++---------=");
        LocalDateTime localDateTime1 = localDateTime.plusDays(1).minusDays(1);
        LocalDateTime localDateTime2 = localDateTime.plusDays(3).minusHours(1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2.withMinute(16));*/

        //with
        /*System.out.println("==================with=================");
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(lastDay);
        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
        // 本月最后一个nextMonthFirstDay.getDayOfWeek()的日期
        LocalDate with = LocalDate.now().with(TemporalAdjusters.lastInMonth(firstDay.getDayOfWeek()));
        System.out.println(with);*/

        //isBefore isAfter
        /*boolean isAfter = LocalDateTime.now().isAfter(LocalDateTime.of(2020, 8, 19, 20, 19, 20));
        boolean isBefore = LocalDateTime.now().isBefore(LocalDateTime.of(2020, 8, 19, 20, 19, 20));
        LocalDateTime now = LocalDateTime.now();
        boolean equalTime = now.isEqual(now);
        System.out.println("isAfter：" + isAfter + " isBefore:" + isBefore + " equalTime:" + equalTime) ;*/

        // duration  period
        /*LocalDateTime now = LocalDateTime.now();
        LocalDateTime compareTime = now.plusDays(1).minusHours(3).minusMinutes(2);
        Duration between = Duration.between(now, compareTime);
        System.out.println(between);
        System.out.println(between.getSeconds());
        //用于验证后面时间是否大于前面时间
        System.out.println(between.isNegative());
        *//*Duration between1 = Duration.between(compareTime, now);
        System.out.println(between1);*//*
        Period until = now.toLocalDate().until(compareTime.toLocalDate());
        System.out.println(until);
        *//*System.out.println(compareTime.toLocalDate().until(now.toLocalDate()));*//**/

        //新旧API转换
        /*Instant ins1 = new Date().toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(ins1, ZoneId.systemDefault());
        System.out.println(localDateTime);
        // Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = Calendar.getInstance().toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
        LocalDate localDate = zdt.toLocalDate();*/

        //新转旧
        // ZonedDateTime -> long:
        ZonedDateTime zdt = ZonedDateTime.now();
        long ts = zdt.toEpochSecond() * 1000;

        // long -> Date:
        Date date = new Date(ts);

        // long -> Calendar:
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        calendar.setTimeInMillis(zdt.toEpochSecond() * 1000);
    }
}
