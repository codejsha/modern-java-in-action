package com.example.demo.chapter05;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class FindingMenu {
    public static void main(String[] args) {
        var menu = DishData.DISHES;

        // finding any vegetarian dish
        log.info("Any vegetarian dish: {}", anyVegetarianDish(menu));

        // finding all vegetarian dishes
        log.info("All vegetarian dishes: {}", allVegetarianDishes(menu));

        // finding no vegetarian dishes
        log.info("No vegetarian dishes: {}", noVegetarianDishes(menu));

        // finding any vegetarian dish (optional)
        log.info("Any vegetarian dish: {}", findAnyVegetarianDish(menu));

        // finding first vegetarian dish (optional)
        log.info("First vegetarian dish: {}", findFirstVegetarianDish(menu));
    }

    /**
     * finding any vegetarian dish
     *
     * @param menu dish list
     * @return true if any vegetarian dish exists
     */
    public static Boolean anyVegetarianDish(List<Dish> menu) {
        return menu.stream()
                .anyMatch(Dish::vegetarian);
    }

    /**
     * finding all vegetarian dishes
     *
     * @param menu dish list
     * @return true if all dishes are vegetarian
     */
    public static Boolean allVegetarianDishes(List<Dish> menu) {
        return menu.stream()
                .allMatch(Dish::vegetarian);
    }

    /**
     * finding no vegetarian dishes
     *
     * @param menu dish list
     * @return true if no vegetarian dishes exist
     */
    public static Boolean noVegetarianDishes(List<Dish> menu) {
        return menu.stream()
                .noneMatch(Dish::vegetarian);
    }

    /**
     * finding vegetarian dish
     *
     * @param menu dish list
     * @return any vegetarian dish
     */
    public static Optional<Dish> findAnyVegetarianDish(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::vegetarian)
                .findAny();
    }

    /**
     * finding vegetarian dish
     *
     * @param menu dish list
     * @return first vegetarian dish
     */
    public static Optional<Dish> findFirstVegetarianDish(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::vegetarian)
                .findFirst();
    }

}
