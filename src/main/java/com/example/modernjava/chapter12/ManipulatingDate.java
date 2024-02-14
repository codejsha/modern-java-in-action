package com.example.modernjava.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class ManipulatingDate {
    public static void absoluteManipulation() {
        final var date1 = LocalDate.of(2017, 9, 21);
        final var date2 = date1.withYear(2011);
        final var date3 = date2.withDayOfMonth(25);
        final var date4 = date3.withMonth(2);
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
        log.info("date3: {}", date3);
        log.info("date4: {}", date4);
    }

    public static void relativeManipulation() {
        final var date1 = LocalDate.of(2017, 9, 21);
        final var date2 = date1.plusWeeks(1);
        final var date3 = date2.minusYears(6);
        final var date4 = date3.plusMonths(6);
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
        log.info("date3: {}", date3);
        log.info("date4: {}", date4);
    }
}
