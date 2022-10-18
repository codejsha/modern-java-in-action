package com.example.demo.chapter11;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Properties;

@Slf4j
public class PropertyProcessing {
    public static int readDurationImperative(Properties props, String name) {
        var value = props.getProperty(name);
        if (value != null) {
            try {
                var i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                // e.printStackTrace();
            }
        }
        return 0;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(PropertyProcessing::stringToOptionalInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static Optional<Integer> stringToOptionalInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
