package com.example.modernjava.chapter08;

import com.example.modernjava.data.PeopleTestData;
import com.example.modernjava.data.TransactionTestData;
import com.example.modernjava.record.Transaction;
import com.example.modernjava.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CollectionProcessingTest {
    private List<Transaction> transactions;
    private List<String> codes;
    private Map<String, Integer> friends;
    private Map<String, String> friendMovies;
    private Map<String, String> familyMovies;

    @BeforeEach
    void setUp() {
        transactions = TransactionTestData.TRANSACTIONS;
        codes = TransactionTestData.REFERENCE_CODES;
        friends = PeopleTestData.FRIENDS;
        friendMovies = PeopleTestData.FRIEND_FAVORITE_MOVIES;
        familyMovies = PeopleTestData.FAMILY_FAVORITE_MOVIES;
    }

    @Test
    void testRemoveTransactionIn2011() {
        final var result = CollectionProcessing.removeTransactionIn2011(
                CollectionUtils.createModifiableList(transactions));
        assertNotNull(result);
        assertEquals(4, result.size());
        result.forEach(transaction -> {
            assertNotEquals(2011, transaction.year());
        });
        log.info("Exclude transactions that occurred in 2011: {}", result);
    }

    @Test
    void testReplaceAllCharactersWithUppercase() {
        final var result = CollectionProcessing.replaceAllCharactersWithUppercase(
                CollectionUtils.createModifiableList(codes));
        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(code -> {
            assertEquals(code, code.toUpperCase());
        });
        log.info("Replace all characters in reference codes with uppercase: {}", result);
    }

    @Test
    void testForEachFriends() {
        final var result = CollectionProcessing.forEachFriends(friends);
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Iterate over friends: {}", result);
    }

    @Test
    void testSortFavoriteMoviesByKey() {
        final var result = CollectionProcessing.sortFavoriteMoviesByKey(friendMovies);
        final var orderedList = friendMovies.keySet().stream().sorted().toList();
        assertNotNull(result);
        assertEquals(orderedList, result.keySet().stream().toList());
        log.info("Sort favorite movies by key: {}", result);
    }

    @Test
    void testSortFavoriteMoviesByValue() {
        final var result = CollectionProcessing.sortFavoriteMoviesByValue(friendMovies);
        final var orderedList = friendMovies.values().stream().sorted().toList();
        assertNotNull(result);
        assertEquals(orderedList, result.values().stream().toList());
        log.info("Sort favorite movies by value: {}", result);
    }

    @Test
    void testGetFavoriteMoviesWithDefault() {
        final var friend = "Thibaut";
        final var result = CollectionProcessing.getFavoriteMoviesWithDefault(friendMovies, friend);
        assertNotNull(result);
        assertEquals("Matrix", result);
        log.info("Get favorite movie with default: name={} move={}", friend, result);
    }

    @Test
    void testRemoveFavoriteMovie() {
        final var friend = "Raphael";
        final var movie = "Star Wars";
        final var result = CollectionProcessing.removeFavoriteMovie(
                CollectionUtils.createModifiableMap(friendMovies), friend, movie);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertNull(result.get("Raphael"));
        log.info("Remove favorite movie: name={} move={}", friend, result);
    }

    @Test
    void testReplaceAllMoviesWithUppercase() {
        final var result = CollectionProcessing.replaceAllMoviesWithUppercase(
                CollectionUtils.createModifiableMap(friendMovies));
        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach((key, value) -> {
            assertEquals(value, value.toUpperCase());
        });
        log.info("Replace all movies with uppercase: {}", result);
    }

    @Test
    void testMergeFavoriteMovies() {
        final var result = CollectionProcessing.mergeFavoriteMovies(friendMovies, familyMovies);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertTrue(result.containsKey("Raphael"));
        assertTrue(result.containsKey("Cristina"));
        assertTrue(result.containsKey("Olivia"));
        assertTrue(result.containsKey("Teo"));
        log.info("Merge favorite movies: {}", result);
    }

    @Test
    void testCountFavoriteMovies() {
        final var result = CollectionProcessing.countFavoriteMovies(
                CollectionProcessing.mergeFavoriteMovies(friendMovies, familyMovies));
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(2, result.get("Star Wars"));
        assertEquals(2, result.get("James Bond"));
        assertEquals(1, result.get("Matrix"));
        log.info("Count favorite movies: {}", result);
    }
}
