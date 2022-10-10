package com.example.demo.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

@Slf4j
public class FormattingDate {
    public static void useDateFormatter() {
        var date = LocalDate.of(2014, 3, 18);
        var str1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        var str2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        log.info("str1: {}", str1);
        log.info("str2: {}", str2);
    }

    public static void useDateParser() {
        var str1 = "20140318";
        var str2 = "2014-03-18";
        var date1 = LocalDate.parse(str1, DateTimeFormatter.BASIC_ISO_DATE);
        var date2 = LocalDate.parse(str2, DateTimeFormatter.ISO_LOCAL_DATE);
        log.info("date1: {}", date1);
        log.info("date2: {}", date2);
    }

    public static void useDateTimeFormatter() {
        var date = LocalDate.of(2014, 3, 18);

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var str = date.format(formatter);
        log.info("str: {}", str);

        var italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        var italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        var italianStr = date.format(italianFormatter);
        log.info("italianStr: {}", italianStr);
    }
}
