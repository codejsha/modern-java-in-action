package com.example.demo.chapter16.discount;

import com.example.demo.util.ThreadUtil;

public class Discount {
    public static String applyDiscount(Quote quote) {
        return quote.shopName() + " price is " + Discount.apply(quote.price(), quote.discountCode());
    }

    private static double apply(double price, Code code) {
        ThreadUtil.delay();
        return ThreadUtil.format(price * (100 - code.percentage) / 100);
    }

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }
}
