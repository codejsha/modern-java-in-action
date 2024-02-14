package com.example.modernjava.chapter06;

import com.example.modernjava.data.DishData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.stream.Collectors.reducing;

@Slf4j
public class ReducingMenu {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;

        log.info("Total calories in menu: {}", calculateTotalCalories(menu));
        log.info("Total calories in menu: {}", calculateTotalCaloriesWithMethodReference(menu));
        log.info("Total calories in menu: {}", calculateTotalCaloriesWithCollectors(menu));
        log.info("Total calories in menu: {}", calculateTotalCaloriesUsingSum(menu));
    }

    /**
     * calculate total calories in menu
     *
     * @param menu menu list
     * @return total calories
     */
    public static int calculateTotalCalories(List<Dish> menu) {
        return menu.stream()
                .collect(reducing(0, Dish::calories, (i, j) -> i + j));
    }

    /**
     * calculate total calories in menu
     *
     * @param menu menu list
     * @return total calories
     */
    public static int calculateTotalCaloriesWithMethodReference(List<Dish> menu) {
        return menu.stream()
                .collect(reducing(0, Dish::calories, Integer::sum));
    }

    /**
     * calculate total calories in menu
     *
     * @param menu menu list
     * @return total calories
     */
    public static int calculateTotalCaloriesWithCollectors(List<Dish> menu) {
        return menu.stream()
                .map(Dish::calories)
                .reduce(0, Integer::sum);
    }

    /**
     * calculate total calories in menu
     *
     * @param menu menu list
     * @return total calories
     */
    public static int calculateTotalCaloriesUsingSum(List<Dish> menu) {
        return menu.stream()
                .mapToInt(Dish::calories)
                .sum();
    }
}
