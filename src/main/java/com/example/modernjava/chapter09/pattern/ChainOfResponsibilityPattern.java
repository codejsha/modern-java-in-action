package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        final UnaryOperator<String> headerProcessing = (text) -> "From Raoul, Mario and Alan: " + text;
        final UnaryOperator<String> spellCheckerProcessing = (text) -> text.replaceAll("labda", "lambda");
        final var pipeline = headerProcessing.andThen(spellCheckerProcessing);

        final var result = pipeline.apply("Aren't labdas really sexy?!!");
        log.info(result);
    }
}
