package com.example.modernjava.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class CollectionFactory {
    public static void main(String[] args) {
        final var list = createList();
        log.info("List: {}", list);

        final var set = createSet();
        log.info("Set: {}", set);

        final var map = createMap();
        log.info("Map: {}", map);

        final var map2 = createMap2();
        log.info("Map: {}", map2);
    }

    public static List<String> createList() {
        return List.of("Raphael", "Olivia", "Thibaut");
    }

    public static Set<String> createSet() {
        return Set.of("Raphael", "Olivia", "Thibaut");
    }

    public static Map<String, Integer> createMap() {
        return Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
    }

    public static Map<String, Integer> createMap2() {
        return Map.ofEntries(
                Map.entry("Raphael", 30),
                Map.entry("Olivia", 25),
                Map.entry("Thibaut", 26)
        );
    }
}
