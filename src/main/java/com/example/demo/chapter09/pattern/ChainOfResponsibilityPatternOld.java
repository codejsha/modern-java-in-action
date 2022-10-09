package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChainOfResponsibilityPatternOld {
    public static void main(String[] args) {
        ProcessingObject<String> processing1 = new HeaderTextProcessing();
        ProcessingObject<String> processing2 = new SpellCheckerProcessing();
        processing1.setSuccessor(processing2);

        String result = processing1.handle("Aren't labdas really sexy?!!");
        log.info(result);
    }

    private static abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T result = handleWork(input);
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
