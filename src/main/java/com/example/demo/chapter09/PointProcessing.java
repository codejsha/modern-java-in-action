package com.example.demo.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class PointProcessing {
    public static void main(String[] args) {
        final var point = new Point(5, 5);
        log.info("Point moved to the right: {}", point.moveBy(10, 0));
        log.info("Point moved to the left: {}", point.moveBy(-10, 0));
        log.info("Point moved to the up: {}", point.moveBy(0, 10));
        log.info("Point moved to the down: {}", point.moveBy(0, -10));
    }

    public record Point(int x, int y) {
        public final static Comparator<Point> compareByXAndThenY =
                Comparator.comparing(Point::x).thenComparing(Point::y);

        public static List<Point> moveAllBy(List<Point> points, int x, int y) {
            points.replaceAll(point -> point.moveBy(x, y));
            return Collections.unmodifiableList(points);
        }

        public Point moveBy(int x, int y) {
            return new Point(this.x + x, this.y + y);
        }
    }
}
