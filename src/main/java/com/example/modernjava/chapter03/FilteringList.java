package com.example.modernjava.chapter03;

import com.example.modernjava.constant.Color;
import com.example.modernjava.data.AppleData;
import com.example.modernjava.record.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringList {
    public static void main(String[] args) {
        final var inventory = AppleData.APPLE_LIST;

        // green apples
        log.info("Green apples: {}", filterGreenApples(inventory));

        // each apple
        inventory.stream()
                .filter(apple -> Color.GREEN.equals(apple.color()))
                .forEach(apple -> log.info("Green apple: {}", apple));

        // each apple's weight
        eachGreenAppleWeight(inventory).forEach(weight -> log.info("Weight of green apple: {}", weight));
    }

    /**
     * filtering green apples
     *
     * @param inventory apple list
     * @return filtered apple list
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        return inventory.stream()
                .filter(apple -> Color.GREEN.equals(apple.color()))
                .toList();
    }

    /**
     * each green apple's weight
     *
     * @param inventory apple list
     * @return filtered list of apple's weight
     */
    public static List<Integer> eachGreenAppleWeight(List<Apple> inventory) {
        return inventory.stream()
                .filter(apple -> Color.GREEN.equals(apple.color()))
                .map(Apple::weight)
                .toList();
    }
}
