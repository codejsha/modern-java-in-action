package com.example.demo.util;

import java.util.*;

public class CollectionUtil {
    public static <T> List<T> createModifiableList(List<T> list) {
        return new ArrayList<>(list);
    }

    public static <K, V> Map<K, V> createModifiableMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <T> Set<T> createModifiableSet(Set<T> set) {
        return new HashSet<>(set);
    }
}
