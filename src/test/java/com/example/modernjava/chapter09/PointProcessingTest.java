package com.example.modernjava.chapter09;

import com.example.modernjava.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PointProcessingTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCompareByXAndThenY() {
        final var p1 = new PointProcessing.Point(10, 15);
        final var p2 = new PointProcessing.Point(10, 20);
        final var result = PointProcessing.Point.compareByXAndThenY.compare(p1, p2);
        assertEquals(-1, result);
        log.info("Compare by x and then y: {}", result);
    }

    @Test
    void testMoveAllBy() {
        final var p1 = new PointProcessing.Point(5, 5);
        final var p2 = new PointProcessing.Point(10, 10);
        final var p3 = new PointProcessing.Point(15, 15);
        var points = List.of(p1, p2, p3);
        points = CollectionUtils.createModifiableList(points);
        final var movedPoints = PointProcessing.Point.moveAllBy(points, 10, 10);
        assertEquals(15, movedPoints.get(0).x());
        assertEquals(15, movedPoints.get(0).y());
        assertEquals(20, movedPoints.get(1).x());
        assertEquals(20, movedPoints.get(1).y());
        assertEquals(25, movedPoints.get(2).x());
        assertEquals(25, movedPoints.get(2).y());
        log.info("Points: {}", points);
    }

    @Test
    void testMoveBy() {
        final var p1 = new PointProcessing.Point(5, 5);
        final var p2 = p1.moveBy(10, 10);
        assertEquals(15, p2.x());
        assertEquals(15, p2.y());
        log.info("Point 1: {}", p1);
        log.info("Point 2: {}", p2);
    }
}
