package com.example.modernjava.chapter11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyProcessingTest {
    private Properties props;

    @BeforeEach
    void setUp() {
        props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
    }

    @Test
    void testReadDurationImperative() {
        assertEquals(5, PropertyProcessing.readDurationImperative(props, "a"));
        assertEquals(0, PropertyProcessing.readDurationImperative(props, "b"));
        assertEquals(0, PropertyProcessing.readDurationImperative(props, "c"));
        assertEquals(0, PropertyProcessing.readDurationImperative(props, "d"));
    }

    @Test
    void testReadDurationWithOptional() {
        assertEquals(5, PropertyProcessing.readDurationWithOptional(props, "a"));
        assertEquals(0, PropertyProcessing.readDurationWithOptional(props, "b"));
        assertEquals(0, PropertyProcessing.readDurationWithOptional(props, "c"));
        assertEquals(0, PropertyProcessing.readDurationWithOptional(props, "d"));
    }

    @Test
    void testStringToOptionalInt() {
        final var result1 = PropertyProcessing.stringToOptionalInt(props.getProperty("a"));
        assertEquals(5, result1.orElse(0));

        final var result2 = PropertyProcessing.stringToOptionalInt(props.getProperty("b"));
        assertEquals(Optional.empty(), result2);

        final var result3 = PropertyProcessing.stringToOptionalInt(props.getProperty("c"));
        assertEquals(-3, result3.orElse(0));
    }
}
