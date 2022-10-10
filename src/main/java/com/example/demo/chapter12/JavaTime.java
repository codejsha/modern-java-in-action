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
        var date = LocalDate.of(2014, 3, 18);
        var year = date.getYear();
        var month = date.getMonth();
        var day = date.getDayOfMonth();
        var dow = date.getDayOfWeek();
        var len = date.lengthOfMonth();
        var leap = date.isLeapYear();
        log.info("date: {}", date);

        var y = date.get(ChronoField.YEAR);
        var m = date.get(ChronoField.MONTH_OF_YEAR);
        var d = date.get(ChronoField.DAY_OF_MONTH);
    }

    public static void useLocalTime() {
        var time = LocalTime.of(13, 45, 20);
        var hour = time.getHour();
        var minute = time.getMinute();
        var second = time.getSecond();
        log.info("time: {}", time);
    }

    public static void useLocalDateTime() {
        var date = LocalDate.of(2014, 3, 18);
        var time = LocalTime.of(13, 45, 20);

        var dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        var dateTime2 = LocalDateTime.of(date, time);
        var dateTime3 = date.atTime(13, 45, 20);
        var dateTime4 = date.atTime(time);
        var dateTime5 = time.atDate(date);
        log.info("dateTime1: {}", dateTime1);

        // local date and local time
        var date1 = dateTime1.toLocalDate();
        var time1 = dateTime1.toLocalTime();
        log.info("date1: {}", date1);
        log.info("time1: {}", time1);
    }

    public static void useInstant() {
        var instant1 = Instant.ofEpochSecond(3);
        var instant2 = Instant.ofEpochSecond(3, 0);
        var instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        var instant4 = Instant.ofEpochSecond(4, -1_000_000_000);

        // instant
        var instant = Instant.ofEpochSecond(44 * 365 * 86400);
        var now = Instant.now();
        log.info("now: {}", now);
    }

    public static void useDuration() {
        var date = LocalDate.of(2014, 3, 18);
        var time = LocalTime.of(13, 45, 20);
        var dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        var dateTime2 = LocalDateTime.of(date, time);
        var time1 = dateTime1.toLocalTime();
        var time2 = dateTime2.toLocalTime();
        var instant1 = Instant.ofEpochSecond(3);
        var instant2 = Instant.ofEpochSecond(3, 0);

        // duration
        var duration1 = Duration.between(time1, time2);
        var duration2 = Duration.between(dateTime1, dateTime2);
        var duration3 = Duration.between(instant1, instant2);

        var threeMinutes1 = Duration.ofMinutes(3);
        var threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        log.info("threeMinutes: {}", threeMinutes2);
    }

    public static void usePeriod() {
        var tenDays = Period.ofDays(10);
        var threeWeeks = Period.ofWeeks(3);
        var twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

    public static void useCalendarSystem() {
        var date = LocalDate.of(2014, 3, 18);

        // calendar system
        var japaneseDate = JapaneseDate.from(date);
        var minguoDate = MinguoDate.from(date);
        var thaiBuddhistDate = ThaiBuddhistDate.from(date);
        var hijrahDate = HijrahDate.from(date);
        log.info("JapaneseDate: {}", japaneseDate);
        log.info("MinguoDate: {}", minguoDate);
        log.info("ThaiBuddhistDate: {}", thaiBuddhistDate);
        log.info("HijrahDate: {}", hijrahDate);
    }
}
