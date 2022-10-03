package com.example.demo.chapter02;

import com.example.demo.record.Apple;
import com.example.demo.enumeration.Color;
import com.example.demo.data.AppleData;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class FilteringAppleAdvanced {
    public static void main(String[] args) {
        var inventory = AppleData.APPLE_LIST;

        log.info("Heavy apples: {}", filterApples(inventory,
                (Apple apple) -> apple.weight() > 150));
        log.info("Green apples: {}", filterApples(inventory,
                (Apple apple) -> Color.GREEN.equals(apple.color())));
        log.info("Red apples: {}", filterApples(inventory,
                (Apple apple) -> Color.RED.equals(apple.color())));
        log.info("Red and heavy apples: {}", filterApples(inventory,
                (Apple apple) -> Color.RED.equals(apple.color()) && apple.weight() > 150));

        inventory.sort(Comparator.comparingInt(Apple::weight));
        log.info("Sorted inventory: {}", inventory);
    }

    /**
     * filtering method for predicate
     * @param inventory apple list
     * @param predicate predicate
     * @return filtered apple list
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        var result = new ArrayList<Apple>();
        for (var apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
