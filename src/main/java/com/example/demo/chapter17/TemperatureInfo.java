package com.example.demo.chapter17;

import java.util.Random;

public record TemperatureInfo(String town, double temperature) {
    public static final Random random = new Random();

    public static TemperatureInfo fetch(String town) {
        if (random.nextInt(10) == 0) {
            throw new RuntimeException("Error!");
        }
        return new TemperatureInfo(town, random.nextInt(100));
    }

    @Override
    public String toString() {
        return "TemperatureInfo{town='" + town + "', temperature=" + temperature + "}";
    }
}
