package com.example.modernjava.chapter19.higherorder;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.UnaryOperator;

@Slf4j
public class TransformationPipeline {
    public static void main(String[] args) {
        final UnaryOperator<String> addHeader = Letter::addHeader;
        final Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                        .andThen(Letter::addFooter);

        log.info(transformationPipeline.apply("C++ stay away from me!"));
    }

    private static class Letter {
        public static String addHeader(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }

        public static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("C\\+\\+", "**Censored**");
        }
    }
}
