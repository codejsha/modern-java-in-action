package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.*;

@Slf4j
public class TimeZoneProcessing {
    public static void useTimeZone() {
        var romeZone = ZoneId.of("Europe/Rome");

        var date = LocalDate.of(2014, 3, 18);
        var zdt1 = date.atStartOfDay(romeZone);

        var datetime = LocalDateTime.of(2014, 3, 18, 13, 45);
        var zdt2 = datetime.atZone(romeZone);

        var instant = Instant.now();
        var zdt3 = instant.atZone(romeZone);
    }

    public static void useTimeZone2() {
        var romeZone = ZoneId.of("Europe/Rome");
        var instant = Instant.now();
        var zdt = instant.atZone(romeZone);

        var datetime = zdt.toLocalDateTime();
        var date = zdt.toLocalDate();
        var time = zdt.toLocalTime();

        var dateTime2 = LocalDateTime.ofInstant(instant, romeZone);
        var date2 = LocalDate.ofInstant(instant, romeZone);
        var time2 = LocalTime.ofInstant(instant, romeZone);
    }
}
