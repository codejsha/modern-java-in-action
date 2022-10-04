package com.example.demo.data;

import com.example.demo.record.Dish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishTestData {
    public static final List<Dish> DISH_LIST = Arrays.asList(
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

    public static final List<Dish> SPECIAL_DISH_LIST = Arrays.asList(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
    );

    public static final Map<String, List<String>> DISH_TAGS = new HashMap<>() {
        {
            put("pork", Arrays.asList("greasy", "salty"));
            put("beef", Arrays.asList("salty", "roasted"));
            put("chicken", Arrays.asList("fried", "crisp"));
            put("french fries", Arrays.asList("greasy", "fried"));
            put("rice", Arrays.asList("light", "natural"));
            put("season fruit", Arrays.asList("fresh", "natural"));
            put("pizza", Arrays.asList("tasty", "salty"));
            put("prawns", Arrays.asList("tasty", "roasted"));
            put("salmon", Arrays.asList("delicious", "fresh"));
        }
    };
}
