package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = (text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (text) -> text.replaceAll("labda", "lambda");
        var pipeline = headerProcessing.andThen(spellCheckerProcessing);

        var result = pipeline.apply("Aren't labdas really sexy?!!");
        log.info(result);
    }
}
