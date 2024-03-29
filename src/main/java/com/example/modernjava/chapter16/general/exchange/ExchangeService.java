package com.example.modernjava.chapter16.general.exchange;

import com.example.modernjava.util.ThreadUtils;

public class ExchangeService {
    public static final double DEFAULT_RATE = 1.35;

    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        ThreadUtils.delay();
        return destination.rate / source.rate;
    }

    public enum Money {
        USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

        private final double rate;

        Money(double rate) {
            this.rate = rate;
        }
    }
}
