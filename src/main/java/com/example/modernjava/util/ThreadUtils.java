package com.example.modernjava.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadUtils {
    private static final DecimalFormat formatter =
            new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        final var delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomDelay() {
        final var delay = 500 + (int) (Math.random() * 2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return Double.parseDouble(formatter.format(number));
        }
    }
}
