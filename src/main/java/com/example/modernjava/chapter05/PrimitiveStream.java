package com.example.modernjava.chapter05;

import com.example.modernjava.data.DishData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PrimitiveStream {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;

        log.info("Sum of calories: {}", sumOfCalories(menu));
        log.info("Max of calories: {}", maxOfCalories(menu));
    }

    /**
     * sum of calories in menu
     *
     * @param menu menu list
     * @return sum of calories
     */
    public static int sumOfCalories(List<Dish> menu) {
        return menu.stream()
                .mapToInt(Dish::calories)
                .sum();
    }

    /**
     * max of calories in menu
     *
     * @param menu menu list
     * @return max of calories
     */
    public static int maxOfCalories(List<Dish> menu) {
        return menu.stream()
                .mapToInt(Dish::calories)
                .max()
                .orElse(0);
    }

}
