package com.example.demo.chapter08;

import com.example.demo.data.PeopleData;
import com.example.demo.data.TransactionData;
import com.example.demo.record.Transaction;
import com.example.demo.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CollectionProcessing {
    public static void main(String[] args) {
        var transactions = TransactionData.TRANSACTIONS;
        var codes = TransactionData.REFERENCE_CODES;
        var friends = PeopleData.FRIENDS;
        var friendMovies = PeopleData.FRIEND_FAVORITE_MOVIES;
        var familyMovies = PeopleData.FAMILY_FAVORITE_MOVIES;

        log.info("Exclude transactions that occurred in 2011: {}",
                removeTransactionIn2011(CollectionUtil.createModifiableList(transactions)));
        log.info("Replace all characters in reference codes with uppercase: {}",
                replaceAllCharactersWithUppercase(CollectionUtil.createModifiableList(codes)));
        log.info("Iterate over friends: {}", forEachFriends(friends));
        log.info("Sort favorite movies by key: {}", sortFavoriteMoviesByKey(friendMovies));
        log.info("Sort favorite movies by value: {}", sortFavoriteMoviesByValue(friendMovies));

        var friend = "Thibaut";
        log.info("Get favorite movie with default: name={} move={}", friend,
                getFavoriteMoviesWithDefault(friendMovies, friend));

        var friend2 = "Raphael";
        var movie = "Star Wars";
        log.info("Remove favorite movie: {}", removeFavoriteMovie(
                CollectionUtil.createModifiableMap(friendMovies), friend2, movie));

        log.info("Replace all movies with uppercase: {}", replaceAllMoviesWithUppercase(
                CollectionUtil.createModifiableMap(friendMovies)));

        var everyoneMovies = mergeFavoriteMovies(friendMovies, familyMovies);
        log.info("Merge favorite movies: {}", everyoneMovies);
        log.info("Count favorite movies: {}", countFavoriteMovies(everyoneMovies));
    }

    /**
     * remove elements from a list
     *
     * @param transactions transaction list
     * @return modified transaction list
     */
    public static List<Transaction> removeTransactionIn2011(List<Transaction> transactions) {
        transactions.removeIf(transaction -> transaction.year() == 2011);
        return Collections.unmodifiableList(transactions);
    }

    /**
     * replace all characters in a list
     *
     * @param codes reference code list
     * @return modified reference code list
     */
    public static List<String> replaceAllCharactersWithUppercase(List<String> codes) {
        codes.replaceAll(String::toUpperCase);
        return Collections.unmodifiableList(codes);
    }

    /**
     * iterate over map
     *
     * @param friends friend map
     * @return friend map
     */
    public static Map<String, Integer> forEachFriends(Map<String, Integer> friends) {
        friends.forEach((name, age) -> log.info("Friend {} is {} years old", name, age));
        return friends;
    }

    /**
     * sort map
     *
     * @param favoriteMovies favorite movie map
     * @return sorted favorite movie map
     */
    public static Map<String, String> sortFavoriteMoviesByKey(Map<String, String> favoriteMovies) {
        var newFavoriteMovies = favoriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        TreeMap::new
                ));
        return Collections.unmodifiableMap(newFavoriteMovies);
    }

    /**
     * sort map
     *
     * @param favoriteMovies favorite movie map
     * @return sorted favorite movie map
     */
    public static Map<String, String> sortFavoriteMoviesByValue(Map<String, String> favoriteMovies) {
        var newFavoriteMovies = favoriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        return Collections.unmodifiableMap(newFavoriteMovies);
    }

    /**
     * get value from map with default
     *
     * @param favoriteMovies favorite movie map
     * @return favorite movie
     */
    public static String getFavoriteMoviesWithDefault(Map<String, String> favoriteMovies, String name) {
        return favoriteMovies.getOrDefault(name, "Matrix");
    }

    /**
     * remove entry from map
     *
     * @param favoriteMovies favorite movie map
     * @param name           friend name
     * @param movie          favorite movie
     * @return modified favorite movie map
     */
    public static Map<String, String> removeFavoriteMovie(
            Map<String, String> favoriteMovies, String name, String movie) {
        favoriteMovies.remove(name, movie);
        return Collections.unmodifiableMap(favoriteMovies);
    }

    /**
     * replace all values in map
     *
     * @param favoriteMovies favorite movie map
     * @return modified favorite movie map
     */
    public static Map<String, String> replaceAllMoviesWithUppercase(Map<String, String> favoriteMovies) {
        favoriteMovies.replaceAll((name, movie) -> movie.toUpperCase());
        return Collections.unmodifiableMap(favoriteMovies);
    }

    /**
     * merge two maps
     *
     * @param friendMovies friend favorite movie map
     * @param familyMovies family favorite movie map
     * @return merged favorite movie map
     */
    public static Map<String, String> mergeFavoriteMovies(
            Map<String, String> friendMovies, Map<String, String> familyMovies) {
        var newFavoriteMovies = new HashMap<>(friendMovies);
        familyMovies.forEach((name, movie) -> {
            newFavoriteMovies.merge(name, movie, (oldValue, newValue) -> oldValue + ", " + newValue);
        });
        return Collections.unmodifiableMap(newFavoriteMovies);
    }

    /**
     * count elements in map
     *
     * @param favoriteMovies favorite movie map
     * @return count of favorite movies
     */
    public static Map<String, Long> countFavoriteMovies(Map<String, String> favoriteMovies) {
        return favoriteMovies.values().stream()
                .flatMap(movies -> Arrays.stream(movies.split(", ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
