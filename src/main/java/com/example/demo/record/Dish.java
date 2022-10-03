package com.example.demo.record;

import com.example.demo.enumeration.DishType;

public record Dish(
        String name,
        boolean vegetarian,
        int calories,
        DishType type) {
}
