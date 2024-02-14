package com.example.modernjava.chapter06;

import com.example.modernjava.constant.CaloricLevel;
import com.example.modernjava.data.DishData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

@Slf4j
public class GroupingMenu {
    public static void main(String[] args) {
        final var menu = DishData.DISHES;
        final var dishTags = DishData.DISH_TAGS;

        log.info("Dishes grouped by type: {}", GroupingMenu.groupDishesByType(menu));
        log.info("Dishes grouped by caloric level: {}", GroupingMenu.groupDishesByCaloricLevel(menu));
        log.info("Caloric dishes grouped by type: {}", GroupingMenu.groupCaloricDishesByType(menu));
        log.info("Dish names grouped by type: {}", GroupingMenu.groupDishNamesByType(menu));
        log.info("Dish tags grouped by type: {}", GroupingMenu.groupDishTagsByType(menu, dishTags));
        log.info("Dishes grouped by type and caloric level: {}", GroupingMenu.groupDishesByTypeAndCaloricLevel(menu));
        log.info("Number of dishes in groups: {}", GroupingMenu.countDishesInGroups(menu));
        log.info("Most caloric dishes by type: {}", GroupingMenu.mostCaloricDishesByType(menu));
        log.info("Most caloric dishes by type: {}", GroupingMenu.mostCaloricDishesByTypeWithoutOptional(menu));
        log.info("Most caloric dishes by type: {}", GroupingMenu.mostCaloricDishesByTypeWithToMap(menu));
        log.info("Total calories by type: {}", GroupingMenu.sumCaloriesByType(menu));
        log.info("Caloric levels by type: {}", GroupingMenu.caloricLevelsByType(menu));
        log.info("Caloric levels by type: {}", GroupingMenu.caloricLevelsByTypeHashSet(menu));
    }

    /**
     * Dishes grouped by type
     *
     * @param menu menu list
     * @return menu grouped by type
     */
    public static Map<Dish.Type, List<Dish>> groupDishesByType(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type));
    }

    /**
     * Dishes grouped by caloric level
     *
     * @param menu menu list
     * @return menu grouped by caloric level
     */
    public static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.calories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.calories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
    }

    /**
     * Caloric dishes grouped by type
     *
     * @param menu menu list
     * @return menu grouped by type
     */
    public static Map<Dish.Type, List<Dish>> groupCaloricDishesByType(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.calories() > 500)
                .collect(groupingBy(Dish::type));
    }

    /**
     * Dish names grouped by type
     *
     * @param menu menu list
     * @return menu grouped by type
     */
    public static Map<Dish.Type, List<String>> groupDishNamesByType(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        mapping(Dish::name, toList())));
    }

    /**
     * Dish tags grouped by type
     *
     * @param menu     menu list
     * @param dishTags dish tags
     * @return menu grouped by type
     */
    public static Map<Dish.Type, Set<String>> groupDishTagsByType(List<Dish> menu, Map<String, List<String>> dishTags) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        flatMapping(dish -> dishTags.get(dish.name()).stream(), toSet())));
    }

    /**
     * Dishes grouped by type and caloric level
     *
     * @param menu menu list
     * @return menu grouped by type and caloric level
     */
    public static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishesByTypeAndCaloricLevel(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        groupingBy(dish -> {
                            if (dish.calories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.calories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })));
    }

    /**
     * Count dishes in groups
     *
     * @param menu menu list
     * @return count of dishes in groups
     */
    public static Map<Dish.Type, Long> countDishesInGroups(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type, counting()));
    }

    /**
     * Most caloric dishes by type
     *
     * @param menu menu list
     * @return most caloric dishes by type
     */
    public static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        maxBy(Comparator.comparingInt(Dish::calories))));
    }

    /**
     * Most caloric dishes by type
     *
     * @param menu menu list
     * @return most caloric dishes by type
     */
    public static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOptional(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::calories)), Optional::get)));
    }

    /**
     * Most caloric dishes by type
     *
     * @param menu menu list
     * @return most caloric dishes by type
     */
    public static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithToMap(List<Dish> menu) {
        return menu.stream()
                .collect(toMap(Dish::type, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Dish::calories))));

    }

    /**
     * Sum calories by type
     *
     * @param menu menu list
     * @return sum calories by type
     */
    public static Map<Dish.Type, Integer> sumCaloriesByType(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        summingInt(Dish::calories)));
    }

    /**
     * Caloric levels by type
     *
     * @param menu menu list
     * @return caloric levels by type
     */
    public static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        mapping(dish -> {
                            if (dish.calories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.calories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, toSet())));
    }

    /**
     * Caloric levels by type
     *
     * @param menu menu list
     * @return caloric levels by type
     */
    public static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTypeHashSet(List<Dish> menu) {
        return menu.stream()
                .collect(groupingBy(Dish::type,
                        mapping(dish -> {
                            if (dish.calories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.calories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, toCollection(HashSet::new))));
    }
}
