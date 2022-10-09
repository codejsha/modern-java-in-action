package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyPattern {
    public static void main(String[] args) {
        var validator1 = new Validator((str) -> str.matches("\\d+"));
        log.info("Is numeric: {}", validator1.validate("aaaa"));

        var validator2 = new Validator((str) -> str.matches("[a-z]+"));
        log.info("Is all lowercase: {}", validator2.validate("bbbb"));
    }

    public interface ValidationStrategy {
        boolean execute(String str);
    }

    public record Validator(ValidationStrategy strategy) {
        public boolean validate(String str) {
            return strategy.execute(str);
        }
    }
}
