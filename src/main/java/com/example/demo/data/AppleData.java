package com.example.demo.data;

import com.example.demo.enumeration.Color;
import com.example.demo.record.Apple;

import java.util.List;

public class AppleData {
    public static final List<Apple> APPLE_LIST = List.of(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
    );
}
