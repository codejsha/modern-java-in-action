package com.example.demo.chapter06;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.*;

@Slf4j
public class SummarizingMenu {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;

        log.info("Total calories in menu: {}", sumTotalCalories(menu));
        log.info("Average calories in menu: {}", calculateAverageCalories(menu));
        log.info("Min calories in menu: {}", reduceMinCalories(menu));
        log.info("Max calories in menu: {}", reduceMaxCalories(menu));
        log.info("Statistics info in menu: {}", summarizeDishes(menu));
        log.info("Joining menu: {}", joiningMenu(menu));
    }

    /**
     * summarize total calories in menu
     *
     * @param menu menu list
     * @return total calories
     */
    public static int sumTotalCalories(List<Dish> menu) {
        return menu.stream()
                .collect(summingInt(Dish::calories));
    }

    /**
     * calculate average calories in menu
     *
     * @param menu menu list
     * @return average calories
     */
    public static double calculateAverageCalories(List<Dish> menu) {
        return Math.round(menu.stream()
                .collect(averagingInt(Dish::calories)) * 100) / 100.0;
    }

    /**
     * reduce min calories in menu
     *
     * @param menu menu list
     * @return min calories
     */
    public static int reduceMinCalories(List<Dish> menu) {
        return menu.stream()
                .min(Comparator.comparingInt(Dish::calories))
                .map(Dish::calories)
                .orElse(-1);
    }

    /**
     * reduce max calories in menu
     *
     * @param menu menu list
     * @return max calories
     */
    public static int reduceMaxCalories(List<Dish> menu) {
        return menu.stream()
                .max(Comparator.comparingInt(Dish::calories))
                .map(Dish::calories)
                .orElse(-1);
    }

    /**
     * summarize info in menu
     *
     * @param menu menu list
     * @return summary info
     */
    public static IntSummaryStatistics summarizeDishes(List<Dish> menu) {
        return menu.stream()
                .collect(summarizingInt(Dish::calories));
    }

    /**
     * joining menu
     *
     * @param menu menu list
     * @return menu string
     */
    public static String joiningMenu(List<Dish> menu) {
        return menu.stream()
                .map(Dish::name)
                .collect(joining(", "));
    }
}
