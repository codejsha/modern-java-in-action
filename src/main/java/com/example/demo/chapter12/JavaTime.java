package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

@Slf4j
public class JavaTime {
    public static void main(String[] args) {
        useLocalDate();
        useLocalTime();
        useLocalDateTime();
        useInstant();
        useDuration();
        usePeriod();
        useCalendarSystem();
    }

    public static void useLocalDate() {
        final var date = LocalDate.of(2014, 3, 18);
        final var year = date.getYear();
        final var month = date.getMonth();
        final var day = date.getDayOfMonth();
        final var dow = date.getDayOfWeek();
        final var len = date.lengthOfMonth();
        final var leap = date.isLeapYear();
        log.info("date: {}", date);

        final var y = date.get(ChronoField.YEAR);
        final var m = date.get(ChronoField.MONTH_OF_YEAR);
        final var d = date.get(ChronoField.DAY_OF_MONTH);
    }

    public static void useLocalTime() {
        final var time = LocalTime.of(13, 45, 20);
        final var hour = time.getHour();
        final var minute = time.getMinute();
        final var second = time.getSecond();
        log.info("time: {}", time);
    }

    public static void useLocalDateTime() {
        final var date = LocalDate.of(2014, 3, 18);
        final var time = LocalTime.of(13, 45, 20);

        final var dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        final var dateTime2 = LocalDateTime.of(date, time);
        final var dateTime3 = date.atTime(13, 45, 20);
        final var dateTime4 = date.atTime(time);
        final var dateTime5 = time.atDate(date);
        log.info("dateTime1: {}", dateTime1);

        // local date and local time
        final var date1 = dateTime1.toLocalDate();
        final var time1 = dateTime1.toLocalTime();
        log.info("date1: {}", date1);
        log.info("time1: {}", time1);
    }

    public static void useInstant() {
        final var instant1 = Instant.ofEpochSecond(3);
        final var instant2 = Instant.ofEpochSecond(3, 0);
        final var instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        final var instant4 = Instant.ofEpochSecond(4, -1_000_000_000);

        // instant
        final var instant = Instant.ofEpochSecond(44 * 365 * 86400);
        final var now = Instant.now();
        log.info("now: {}", now);
    }

    public static void useDuration() {
        final var date = LocalDate.of(2014, 3, 18);
        final var time = LocalTime.of(13, 45, 20);
        final var dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        final var dateTime2 = LocalDateTime.of(date, time);
        final var time1 = dateTime1.toLocalTime();
        final var time2 = dateTime2.toLocalTime();
        final var instant1 = Instant.ofEpochSecond(3);
        final var instant2 = Instant.ofEpochSecond(3, 0);

        // duration
        final var duration1 = Duration.between(time1, time2);
        final var duration2 = Duration.between(dateTime1, dateTime2);
        final var duration3 = Duration.between(instant1, instant2);

        final var threeMinutes1 = Duration.ofMinutes(3);
        final var threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        log.info("threeMinutes: {}", threeMinutes2);
    }

    public static void usePeriod() {
        final var tenDays = Period.ofDays(10);
        final var threeWeeks = Period.ofWeeks(3);
        final var twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

    public static void useCalendarSystem() {
        final var date = LocalDate.of(2014, 3, 18);

        // calendar system
        final var japaneseDate = JapaneseDate.from(date);
        final var minguoDate = MinguoDate.from(date);
        final var thaiBuddhistDate = ThaiBuddhistDate.from(date);
        final var hijrahDate = HijrahDate.from(date);
        log.info("JapaneseDate: {}", japaneseDate);
        log.info("MinguoDate: {}", minguoDate);
        log.info("ThaiBuddhistDate: {}", thaiBuddhistDate);
        log.info("HijrahDate: {}", hijrahDate);
    }
}
