package com.example.demo.chapter13.draw.v1;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42, 42);
            r.Draw();
        });
    }
}
