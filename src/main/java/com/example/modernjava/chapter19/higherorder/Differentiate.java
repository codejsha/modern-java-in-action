package com.example.modernjava.chapter19.higherorder;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Differentiate {
    public static void main(String[] args) {
        final Function<Double, Double> f = (Double x) -> x * x;
        final var df = differentiate(f);
        log.info(df.apply(3.0).toString());
    }

    public static Function<Double, Double> differentiate(Function<Double, Double> f) {
        return (Double x) -> {
            final var h = 1e-5;
            return (f.apply(x + h) - f.apply(x)) / h;
        };
    }
}
