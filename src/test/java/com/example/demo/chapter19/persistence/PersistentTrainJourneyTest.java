package com.example.demo.chapter19.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.demo.chapter19.persistence.PersistentTrainJourney.*;
import static org.junit.jupiter.api.Assertions.*;

class PersistentTrainJourneyTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void linkJourneyToAnotherJourney() {
        // Arrange
        final var journey1 = new TrainJourney(40, new TrainJourney(30, null));
        final var journey2 = new TrainJourney(20, new TrainJourney(50, null));

        // Act
        final var linked1 = link(journey1, journey2);
        final var linked2 = link(journey1, journey2);

        // Assert
        assertSame(linked1, linked2); // Ensure that link returns the same object
        assertEquals(40, linked1.price);
        assertEquals(30, linked1.onward.price);
        assertEquals(20, linked1.onward.onward.price);
        assertEquals(50, linked1.onward.onward.onward.price);

        assertThrowsExactly(StackOverflowError.class, () -> visit(linked1, journey -> {
            System.out.println("price: " + journey.price);
        }));
    }

    @Test
    void appendJourneyToAnotherJourney() {
        // Arrange
        final var journey1 = new TrainJourney(40, new TrainJourney(30, null));
        final var journey2 = new TrainJourney(20, new TrainJourney(50, null));

        // Act
        final var appended1 = append(journey1, journey2);
        final var appended2 = append(journey1, journey2);

        // Assert
        assertNotSame(appended1, appended2); // Ensure that append returns a new object
        assertEquals(40, appended1.price);
        assertEquals(30, appended1.onward.price);
        assertEquals(20, appended1.onward.onward.price);
        assertEquals(50, appended1.onward.onward.onward.price);
        assertEquals(40, appended2.price);
        assertEquals(30, appended2.onward.price);
        assertEquals(20, appended2.onward.onward.price);
        assertEquals(50, appended2.onward.onward.onward.price);
    }
}
