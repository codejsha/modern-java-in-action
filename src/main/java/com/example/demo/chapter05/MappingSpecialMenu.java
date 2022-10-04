package com.example.demo.chapter05;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MappingSpecialMenu {
    public static void main(String[] args) {
        var menu = DishData.SPECIAL_DISH_LIST;

        log.info("Dish names: {}", dishNames(menu));
        log.info("Dish name lengths: {}", dishNameLengths(menu));
        log.info("Unique characters of dish names: {}", uniqueDishNameCharacters(menu));
    }

    /**
     * mapping dish names
     * @param menu dish list
     * @return mapped list
     */
    public static List<String> dishNames(List<Dish> menu) {
        return menu.stream()
                .map(Dish::name)
                .collect(Collectors.toList());
    }

    /**
     * length of dish names
     * @param menu dish list
     * @return mapped list
     */
    public static List<Integer> dishNameLengths(List<Dish> menu) {
        return menu.stream()
                .map(Dish::name)
                .map(String::length)
                .collect(Collectors.toList());
    }

    /**
     * unique characters of dish names
     * @param menu dish list
     * @return flat mapped list
     */
    public static List<String> uniqueDishNameCharacters(List<Dish> menu) {
        return menu.stream()
                .map(Dish::name)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
    }
}
