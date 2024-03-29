package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class ChainOfResponsibilityPatternTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testChainProcessing() {
        final UnaryOperator<String> headerProcessing = (text) -> "From Raoul, Mario and Alan: " + text;
        final UnaryOperator<String> spellCheckerProcessing = (text) -> text.replaceAll("labda", "lambda");
        final var pipeline = headerProcessing.andThen(spellCheckerProcessing);
        final var result = pipeline.apply("Aren't labdas really sexy?!!");
        assertNotNull(result);
        assertEquals("From Raoul, Mario and Alan: Aren't lambdas really sexy?!!", result);
        log.info(result);
    }
}
