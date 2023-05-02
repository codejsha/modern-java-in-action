package com.example.demo.chapter19.patternpatching;

public class PatternMatching {
    /**
     * Pattern matching for instanceof (Java 16)
     *
     * @param obj an object
     * @return the string representation of the object
     */
    public static String matchInstanceof(Object obj) {
        if (obj instanceof String s) {
            return s;
        } else if (obj instanceof Integer i) {
            return i.toString();
        } else {
            return null;
        }
    }

    /**
     * Pattern matching for switch expression (Java 17 preview)
     *
     * @param obj an object
     * @return the string representation of the object
     */
    public static String matchSwitchExpression(Object obj) {
        // return switch (obj) {
        //     case String s -> s;
        //     case Integer i -> i.toString();
        //     default -> null;
        // };

        return null;
    }
}
