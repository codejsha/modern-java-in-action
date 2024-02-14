package com.example.modernjava.chapter05;

import com.example.modernjava.data.DishData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringMenu {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;

        // filtering vegetarian dishes
        log.info("Vegetarian dishes: {}", filterVegetarianDishes(menu));
    }

    /**
     * filtering vegetarian dishes
     *
     * @param menu dish list
     * @return filtered dish list
     */
    public static List<Dish> filterVegetarianDishes(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::vegetarian)
                .toList();
    }
}
