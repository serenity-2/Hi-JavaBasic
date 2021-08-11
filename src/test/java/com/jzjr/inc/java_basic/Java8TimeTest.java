package com.jzjr.inc.java_basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
public class Java8TimeTest {
    @Test
    public void print1() {
        //当前时间的毫秒级时间戳
        long epochMilli = Instant.now().toEpochMilli();
        System.out.println(epochMilli);
        //获取当天日期哦
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //构造指定日期
        LocalDate localDate1 = LocalDate.of(2021, 04, 18);
        System.out.println(localDate1);
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    @Test
    public void print2() {
        //带时区的时间
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiTime = ZonedDateTime.now(shanghaiZoneId);
        System.out.println("上海时间:\t" + shanghaiTime);
        ZoneId toykoId = ZoneId.of("Europe/Paris");
        ZonedDateTime toykoTime = ZonedDateTime.now(toykoId);
        System.out.println("巴黎时间:\t" + toykoTime);
    }

    @Test
    public void print3() {
        //时间格式化
        //日期转字符串
        String now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println("now:\t" + now);
        //字符串转日期
        String future = "2021-07-02 00:00:00";
        LocalDateTime birthday = LocalDateTime.parse(future, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(birthday);

    }

    @Test
    public void print4() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.println(date);
    }
}
