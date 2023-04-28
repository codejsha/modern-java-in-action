package com.example.demo.chapter02;

import com.example.demo.data.AppleData;
import com.example.demo.enumeration.Color;
import com.example.demo.record.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FilteringApple {
    public static void main(String[] args) {
        var inventory = AppleData.APPLE_LIST;

        // behavior parameterization
        log.info("Heavy apples: {}", filterApples(inventory, new AppleHeavyWeightPredicate()));
        // anonymous class
        log.info("Heavy apples: {}", filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.weight() > 150;
            }
        }));
        // lambda expression
        log.info("Heavy apples: {}", filterApples(inventory, (Apple apple) -> apple.weight() > 150));

        // behavior parameterization
        log.info("Green apples: {}", filterApples(inventory, new AppleGreenColorPredicate()));
        // anonymous class
        log.info("Green apples: {}", filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.GREEN.equals(apple.color());
            }
        }));
        // lambda expression
        log.info("Green apples: {}", filterApples(inventory, (Apple apple) -> Color.GREEN.equals(apple.color())));

        // behavior parameterization
        log.info("Red apples: {}", filterApples(inventory, new AppleRedColorPredicate()));
        // anonymous class
        log.info("Red apples: {}", filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.color());
            }
        }));
        // lambda expression
        log.info("Red apples: {}", filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.color())));

        // behavior parameterization
        log.info("Red and heavy apples: {}", filterApples(inventory, new AppleRedColorAndHeavyWeightPredicate()));
        // anonymous class
        log.info("Red and heavy apples: {}", filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.color()) && apple.weight() > 150;
            }
        }));
        // lambda expression
        log.info("Red and heavy apples: {}", filterApples(inventory,
                (Apple apple) -> Color.RED.equals(apple.color()) && apple.weight() > 150));
    }

    /**
     * filtering method for predicate
     *
     * @param inventory apple list
     * @param predicate predicate
     * @return filtered apple list
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        var result = new ArrayList<Apple>();
        for (var apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * predicate interface for apple
     */
    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    /**
     * predicate class for heavy apple
     */
    public static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.weight() > 150;
        }
    }

    /**
     * predicate class for green apple
     */
    public static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.color());
        }
    }

    /**
     * predicate class for red apple
     */
    public static class AppleRedColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.color());
        }
    }

    /**
     * predicate class for red and heavy apple
     */
    public static class AppleRedColorAndHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.color()) && apple.weight() > 150;
        }
    }
}
