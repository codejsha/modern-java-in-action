package com.example.modernjava.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectionUtils {
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
