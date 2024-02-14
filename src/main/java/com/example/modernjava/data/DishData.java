package com.example.modernjava.data;

import com.example.modernjava.record.Dish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishData {
    public static final List<Dish> DISHES = List.of(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static final List<Dish> SPECIAL_DISHES = List.of(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
    );

    public static final Map<String, List<String>> DISH_TAGS = new HashMap<>() {
        {
            put("pork", List.of("greasy", "salty"));
            put("beef", List.of("salty", "roasted"));
            put("chicken", List.of("fried", "crisp"));
            put("french fries", List.of("greasy", "fried"));
            put("rice", List.of("light", "natural"));
            put("season fruit", List.of("fresh", "natural"));
            put("pizza", List.of("tasty", "salty"));
            put("prawns", List.of("tasty", "roasted"));
            put("salmon", List.of("delicious", "fresh"));
        }
    };
}
