package com.example.modernjava.data;

import java.util.Map;

public class PeopleTestData {
    public static final Map<String, Integer> FRIENDS = Map.ofEntries(
            Map.entry("Raphael", 30),
            Map.entry("Olivia", 25),
            Map.entry("Thibaut", 26)
    );

    public static final Map<String, String> FRIEND_FAVORITE_MOVIES = Map.ofEntries(
            Map.entry("Raphael", "Star Wars"),
            Map.entry("Cristina", "Matrix"),
            Map.entry("Olivia", "James Bond")
    );

    public static final Map<String, String> FAMILY_FAVORITE_MOVIES = Map.ofEntries(
            Map.entry("Teo", "Star Wars"),
            Map.entry("Cristina", "James Bond")
    );
}
