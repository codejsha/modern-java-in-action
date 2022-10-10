package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

@Slf4j
public class ManipulatingDate {
    public static void absoluteManipulation() {
        var date1 = LocalDate.of(2017, 9, 21);
        var date2 = date1.withYear(2011);
        var date3 = date2.withDayOfMonth(25);
        var date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2);
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
        log.info("date3: {}", date3);
        log.info("date4: {}", date4);
    }

    public static void relativeManipulation() {
        var date1 = LocalDate.of(2017, 9, 21);
        var date2 = date1.plusWeeks(1);
        var date3 = date2.minusYears(6);
        var date4 = date3.plus(6, ChronoUnit.MONTHS);
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
        log.info("date3: {}", date3);
        log.info("date4: {}", date4);
    }
}
