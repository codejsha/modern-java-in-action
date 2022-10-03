package com.example.demo.data;

import com.example.demo.record.Dish;
import com.example.demo.enumeration.DishType;

import java.util.Arrays;
import java.util.List;

public class DishData {
    public static final List<Dish> DISH_LIST = Arrays.asList(
            new Dish("pork", false, 800, DishType.MEAT),
            new Dish("beef", false, 700, DishType.MEAT),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("pizza", true, 550, DishType.OTHER),
            new Dish("prawns", false, 400, DishType.FISH),
            new Dish("salmon", false, 450, DishType.FISH)
    );

    public static final List<Dish> SPECIAL_DISH_LIST = Arrays.asList(
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("prawns", false, 300, DishType.FISH),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER)
    );
}
