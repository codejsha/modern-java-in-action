package com.example.demo.chapter19.higherorder;

import java.util.function.Function;

public class Differentiate {
    public static void main(String[] args) {
        final Function<Double, Double> f = (Double x) -> x * x;
        final var df = differentiate(f);
        System.out.println(df.apply(3.0));
    }

    public static Function<Double, Double> differentiate(Function<Double, Double> f) {
        return (Double x) -> {
            final var h = 1e-5;
            return (f.apply(x + h) - f.apply(x)) / h;
        };
    }
}
