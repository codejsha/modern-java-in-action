package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyPatternOld {
    public static void main(String[] args) {
        final var validator1 = new Validator(new IsNumeric());
        log.info("Is numeric: {}", validator1.validate("aaaa"));

        final var validator2 = new Validator(new IsAllLowerCase());
        log.info("Is all lowercase: {}", validator2.validate("bbbb"));
    }

    private interface ValidationStrategy {
        boolean execute(String str);
    }

    private static class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String str) {
            return str.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String str) {
            return str.matches("\\d+");
        }
    }

    public static class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean validate(String str) {
            return strategy.execute(str);
        }
    }
}
