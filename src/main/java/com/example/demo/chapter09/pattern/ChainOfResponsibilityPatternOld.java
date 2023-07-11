package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChainOfResponsibilityPatternOld {
    public static void main(String[] args) {
        final var processing1 = new HeaderTextProcessing();
        final var processing2 = new SpellCheckerProcessing();
        processing1.setSuccessor(processing2);

        log.info(processing1.handle("Aren't labdas really sexy?!!"));
    }

    private static abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            final var result = handleWork(input);
            if (successor != null) {
                return successor.handle(result);
            }
            return result;
        }

        protected abstract T handleWork(T input);
    }

    private static class HeaderTextProcessing extends ProcessingObject<String> {
        @Override
        public String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    private static class SpellCheckerProcessing extends ProcessingObject<String> {
        @Override
        public String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
