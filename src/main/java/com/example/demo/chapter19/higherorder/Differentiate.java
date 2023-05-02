package com.example.demo.chapter19.higherorder;

import java.util.function.Function;

public class Differentiate {
    public static void main(String[] args) {
        Function<Double, Double> f = (Double x) -> x * x;
        var df = differentiate(f);
        System.out.println(df.apply(3.0));
    }

    public static Function<Double, Double> differentiate(Function<Double, Double> f) {
        return (Double x) -> {
            var h = 1e-5;
            return (f.apply(x + h) - f.apply(x)) / h;
        };
    }
}
