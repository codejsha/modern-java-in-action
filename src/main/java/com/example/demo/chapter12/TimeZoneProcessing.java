package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.*;

@Slf4j
public class TimeZoneProcessing {
    public static void useTimeZone() {
        final var romeZone = ZoneId.of("Europe/Rome");

        final var date = LocalDate.of(2014, 3, 18);
        final var zdt1 = date.atStartOfDay(romeZone);

        final var datetime = LocalDateTime.of(2014, 3, 18, 13, 45);
        final var zdt2 = datetime.atZone(romeZone);

        final var instant = Instant.now();
        final var zdt3 = instant.atZone(romeZone);
    }

    public static void useTimeZone2() {
        final var romeZone = ZoneId.of("Europe/Rome");
        final var instant = Instant.now();
        final var zdt = instant.atZone(romeZone);

        final var datetime = zdt.toLocalDateTime();
        final var date = zdt.toLocalDate();
        final var time = zdt.toLocalTime();

        final var dateTime2 = LocalDateTime.ofInstant(instant, romeZone);
        final var date2 = LocalDate.ofInstant(instant, romeZone);
        final var time2 = LocalTime.ofInstant(instant, romeZone);
    }
}
