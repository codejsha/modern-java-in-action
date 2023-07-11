package com.example.demo.chapter16.discount;

public record Quote(String shopName, double price, Discount.Code discountCode) {
    public static Quote parse(String s) {
        final String[] split = s.split(":");
        final String shopName = split[0];
        final double price = Double.parseDouble(split[1]);
        final Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }
}
