package com.example.demo.chapter06;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

@Slf4j
public class PartitioningMenu {
    public static void main(String[] args) {
        var menu = DishData.DISH_LIST;
        var dishTags = DishData.DISH_TAGS;

        log.info("Dishes partitioned by vegetarian: {}", PartitioningMenu.partitionByVegetarian(menu));
        log.info("Vegetarian dishes by type: {}", PartitioningMenu.vegetarianDishesByType(menu));
        log.info("Most caloric dishes partitioned by vegetarian: {}", PartitioningMenu.mostCaloricPartitionedByVegetarian(menu));
    }

    /**
     * Dishes partitioned by vegetarian
     * @param menu menu list
     * @return menu partitioned by vegetarian
     */
    public static Map<Boolean, List<Dish>> partitionByVegetarian(List<Dish> menu) {
        return menu.stream()
                .collect(partitioningBy(Dish::vegetarian));
    }

    /**
     * Vegetarian dishes by type
     * @param menu menu list
     * @return vegetarian dishes by type
     */
    public static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType(List<Dish> menu) {
        return menu.stream()
                .collect(partitioningBy(Dish::vegetarian, groupingBy(Dish::type)));
    }

    /**
     * Most caloric dishes partitioned by vegetarian
     * @param menu menu list
     * @return most caloric dishes partitioned by vegetarian
     */
    public static Map<Boolean, Dish> mostCaloricPartitionedByVegetarian(List<Dish> menu) {
        return menu.stream()
                .collect(partitioningBy(Dish::vegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::calories)), Optional::get)));
    }
}
