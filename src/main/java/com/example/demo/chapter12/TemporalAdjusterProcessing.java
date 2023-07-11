package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Slf4j
public class TemporalAdjusterProcessing {
    public static void useTemporalAdjuster() {
        final var date1 = LocalDate.of(2014, 3, 18);
        final var date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        final var date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
        log.info("date3: {}", date3);
    }
}
