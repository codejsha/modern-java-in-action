package com.example.demo.chapter05;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringSpecialMenu {
    public static void main(String[] args) {
        var menu = DishData.SPECIAL_DISHES;

        // filtering dishes with calories less than 320
        log.info("Low calorie dishes: {}", lowCalorieDishes(menu));
        log.info("Low calorie dishes: {}", lowCalorieDishes2(menu));

        // filtering dishes with calories upper more than 300
        log.info("High calorie dishes: {}", highCalorieDishes(menu));

        // filtering dishes with calories upper more than 300 (limit 3)
        log.info("Three high calorie dishes: {}", threeHighCalorieDishes(menu));

        // filtering dishes with calories upper more than 300 (skip first 2)
        log.info("Other high calorie dishes: {}", otherHighCalorieDishes(menu));
    }

    /**
     * filtering dishes with calories less than 320
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> lowCalorieDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.calories() < 320)
                .collect(Collectors.toList());
    }

    /**
     * filtering dishes with calories less than 320
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> lowCalorieDishes2(List<Dish> menu) {
        return menu.stream()
                .takeWhile(dish -> dish.calories() < 320)
                .collect(Collectors.toList());
    }

    /**
     * filtering dishes with calories upper more than 300
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> highCalorieDishes(List<Dish> menu) {
        return menu.stream()
                .dropWhile(dish -> dish.calories() <= 300)
                .collect(Collectors.toList());
    }

    /**
     * filtering dishes with calories upper more than 300 (limit 3)
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> threeHighCalorieDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.calories() > 300)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * filtering dishes with calories upper more than 300 (skip first 2)
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> otherHighCalorieDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.calories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }
}
