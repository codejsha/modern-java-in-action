package com.example.demo.data;

import com.example.demo.record.Apple;
import com.example.demo.enumeration.Color;

import java.util.Arrays;
import java.util.List;

public class AppleData {
    public static final List<Apple> APPLE_LIST = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
    );
}
