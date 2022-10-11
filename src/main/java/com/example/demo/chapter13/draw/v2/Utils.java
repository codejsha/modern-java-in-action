package com.example.demo.chapter13.draw.v2;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setRelativeSize(2, 2);
            r.Draw();
        });
    }
}
