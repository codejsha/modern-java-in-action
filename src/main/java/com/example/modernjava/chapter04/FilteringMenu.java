package com.example.modernjava.chapter04;

import com.example.modernjava.data.DishData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringMenu {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;

        // filtering high calorie dishes (limit 3)
        log.info("High calorie dishes: {}", threeHighCalorieDishes(menu));
    }

    /**
     * filtering high calorie dishes (limit 3)
     *
     * @param menu dish list
     * @return filtered list of dish names
     */
    public static List<String> threeHighCalorieDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.calories() > 300)
                .map(Dish::name)
                .limit(3)
                .toList();
    }
}
