package com.example.modernjava.chapter19.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.modernjava.chapter19.tree.PersistentTree.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistentTreeTest {
    Tree tree;

    @BeforeEach
    void setUp() {
        // arrange
        tree = new Tree("Mary", 22,
                new Tree("Emily", 20,
                        new Tree("Alan", 50, null, null),
                        new Tree("Georgie", 23, null, null)
                ),
                new Tree("Tian", 29,
                        new Tree("Raoul", 23, null, null),
                        null
                )
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void lookupKeys() {
        // act
        final var raoulKey = lookup("Raoul", -1, tree);
        final var jeffKey = lookup("Jeff", -1, tree);
        // assert
        assertEquals(23, raoulKey); // found
        assertEquals(-1, jeffKey);  // not found
    }

    /**
     * Update a tree. This has a side effect that changes the state.
     */
    @Test
    void updateChangeStatus() {
        // act
        final var updatedTree1 = updateFunctionApproach("Jeff", 80, tree);
        final var updatedTree2 = update("Jim", 40, tree);
        final var updatedTree3 = updateFunctionApproach("Jeff", 80, tree);

        // assert
        assertEquals(80, lookup("Jeff", -1, updatedTree3)); // found
        assertEquals(40, lookup("Jim", -1, updatedTree3));  // found
    }

    /**
     * Update a tree using the functional approach
     */
    @Test
    void updateNotChangeStatus() {
        // act
        final var updatedTree1 = updateFunctionApproach("Jeff", 80, tree);
        final var updatedTree2 = update("Jim", 40, tree);

        // assert
        assertEquals(-1, lookup("Jeff", -1, updatedTree2)); // not found
        assertEquals(40, lookup("Jim", -1, updatedTree2));  // found
    }

    @Test
    void updateUsingFunctionalApproach1() {
        // act
        final var updatedTree = updateFunctionApproach("Jeff", 80, tree);
        // assert
        assertEquals(80, lookup("Jeff", -1, updatedTree));
    }

    @Test
    void updateUsingFunctionalApproach2() {
        // act
        final var updatedTree = updateFunctionApproach2("Jeff", 80, tree);
        // assert
        assertEquals(80, lookup("Jeff", -1, updatedTree));
    }
}
