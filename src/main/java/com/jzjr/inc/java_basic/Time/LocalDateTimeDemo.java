package com.jzjr.inc.java_basic.Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒 1612771592
        System.out.println(now.toEpochMilli()); // 毫秒 1612771592090
    }
}
