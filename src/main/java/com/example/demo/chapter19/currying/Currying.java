package com.example.demo.chapter19.currying;

import java.util.function.DoubleUnaryOperator;

public class Currying {
    public static void main(String[] args) {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

        System.out.printf("24 °C = %.2f °F%n", convertCtoF.applyAsDouble(24));
        System.out.printf("US$100 = £%.2f%n", convertUSDtoGBP.applyAsDouble(100));
        System.out.printf("20 km = %.2f miles%n", convertKmtoMi.applyAsDouble(20));

        DoubleUnaryOperator convertFtoC = expandedCurriedConverter(-32, 5.0 / 9, 0);
        System.out.printf("98.6 °F = %.2f °C", convertFtoC.applyAsDouble(98.6));
    }

    public static double convertCtoF(double x) {
        return converter(x, 9.0 / 5, 32);
    }

    /**
     * Converts a quantity using a conversion factor and baseline.
     *
     * @param x quantity you want to convert
     * @param f conversion factor
     * @param b baseline
     * @return converted quantity
     */
    public static double converter(double x, double f, double b) {
        return x * f + b;
    }

    /**
     * Makes a one-argument function using currying.
     *
     * @param f conversion factor
     * @param b baseline
     * @return one-argument conversion function
     */
    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    /**
     * Makes a one-argument function using currying.
     *
     * @param w conversion factor
     * @param y conversion factor
     * @param z baseline
     * @return one-argument conversion function
     */
    public static DoubleUnaryOperator expandedCurriedConverter(double w, double y, double z) {
        return (double x) -> (x + w) * y + z;
    }
}
