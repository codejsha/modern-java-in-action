package com.example.modernjava.chapter16.discount;

import com.example.modernjava.util.ThreadUtils;

public class Discount {
    public static String applyDiscount(Quote quote) {
        return quote.shopName() + " price is " + Discount.apply(quote.price(), quote.discountCode());
    }

    private static double apply(double price, Code code) {
        ThreadUtils.delay();
        return ThreadUtils.format(price * (100 - code.percentage) / 100);
    }

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }
}
