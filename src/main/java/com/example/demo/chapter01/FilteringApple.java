package com.example.demo.chapter01;

import com.example.demo.data.AppleData;
import com.example.demo.constant.Color;
import com.example.demo.record.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class FilteringApple {
    public static void main(String[] args) {
        final var inventory = AppleData.APPLE_LIST;

        log.info("Green apples: {}", filterGreenApples(inventory));
        log.info("Green apples: {}", filterGreenApples2(inventory));
        log.info("Heavy apples: {}", filterHeavyApples(inventory));
        log.info("Heavy apples: {}", filterHeavyApples2(inventory));
        log.info("Weird apples: {}", filterWeirdApples(inventory));
    }

    /**
     * predicate method to filter green apples
     *
     * @param apple apple
     * @return boolean result for condition
     */
    private static boolean isGreenApple(Apple apple) {
        return Color.GREEN.equals(apple.color());
    }

    /**
     * predicate method to filter heavy apples
     *
     * @param apple apple
     * @return boolean result for condition
     */
    private static boolean isHeavyApple(Apple apple) {
        return apple.weight() > 150;
    }

    /**
     * filtering method for predicate
     *
     * @param inventory apple list
     * @param predicate predicate
     * @return filtered apple list
     */
    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        final var result = new ArrayList<Apple>();
        for (var apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * filter green apples by predicate
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        return filterApples(inventory, FilteringApple::isGreenApple);
    }

    /**
     * filter heavy apples by lambda
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterGreenApples2(List<Apple> inventory) {
        return filterApples(inventory, (Apple apple) -> Color.GREEN.equals(apple.color()));
    }

    /**
     * filter heavy apples by predicate
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        return filterApples(inventory, FilteringApple::isHeavyApple);
    }

    /**
     * filter heavy apples by lambda
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterHeavyApples2(List<Apple> inventory) {
        return filterApples(inventory, (Apple apple) -> apple.weight() > 150);
    }

    /**
     * filter weird apples by lambda
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterWeirdApples(List<Apple> inventory) {
        return filterApples(inventory, (Apple apple) -> apple.weight() < 80 || Color.BROWN.equals(apple.color()));
    }
}
