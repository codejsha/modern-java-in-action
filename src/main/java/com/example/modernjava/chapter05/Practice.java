package com.example.modernjava.chapter05;

import com.example.modernjava.data.TraderData;
import com.example.modernjava.data.TransactionData;
import com.example.modernjava.record.Trader;
import com.example.modernjava.record.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Practice {
    public static void main(String[] args) {
        final var transactions = TransactionData.TRANSACTIONS;
        final var traders = TraderData.TRADERS;

        log.info("exercise1 | all transactions in 2011 and sort by value: {}", exercise1(transactions));
        log.info("exercise2 | unique cities where traders work: {}", exercise2(traders));
        log.info("exercise3 | all traders from Cambridge and sort by name: {}", exercise3(transactions));
        log.info("exercise4 | all traders' names sorted alphabetically: {}", exercise4(traders));
        log.info("exercise5 | are any traders based in Milan?: {}", exercise5(traders));
        log.info("exercise6 | print all transactions' values from the traders living in Cambridge: {}", exercise6(transactions));
        log.info("exercise7 | highest value of all the transactions: {}", exercise7(transactions));
        log.info("exercise8 | smallest value of all the transactions: {}", exercise8(transactions));
    }

    /**
     * 1. Find all transactions in the year 2011 and sort them by value (small to high).
     *
     * @param transactions transaction list
     * @return filtered transaction list
     */
    public static List<Transaction> exercise1(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tx -> tx.year() == 2011)
                .sorted(Comparator.comparingInt(Transaction::value))
                .toList();
    }

    /**
     * 2. What are all the unique cities where the traders work?
     *
     * @param traders trader list
     * @return unique city list
     */
    public static List<String> exercise2(List<Trader> traders) {
        return traders.stream()
                .map(Trader::city)
                .distinct()
                .toList();
    }

    /**
     * 3. Find all traders from Cambridge and sort them by name.
     *
     * @param transactions transaction list
     * @return filtered trader list
     */
    public static List<Trader> exercise3(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::trader)
                .filter(trader -> trader.city().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::name))
                .toList();
    }

    /**
     * 4. Return a string of all traders' names sorted alphabetically.
     *
     * @param traders trader list
     * @return trader name string
     */
    public static String exercise4(List<Trader> traders) {
        return traders.stream()
                .map(Trader::name)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    /**
     * 5. Are any traders based in Milan?
     *
     * @param traders trader list
     * @return true if any trader is based in Milan
     */
    public static boolean exercise5(List<Trader> traders) {
        return traders.stream()
                .anyMatch(trader -> trader.city().equals("Milan"));
    }

    /**
     * 6. Print all transactions' values from the traders living in Cambridge.
     *
     * @param transactions transaction list
     * @return transaction value list
     */
    public static List<Integer> exercise6(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tx -> tx.trader().city().equals("Cambridge"))
                .map(Transaction::value)
                .toList();
    }

    /**
     * 7. What's the highest value of all the transactions?
     *
     * @param transactions transaction list
     * @return highest value
     */
    public static int exercise7(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::value)
                .max(Comparator.comparing(Integer::valueOf))
                .orElse(-1);
    }

    /**
     * 8. Find the transaction with the smallest value.
     *
     * @param transactions transaction list
     * @return smallest value
     */
    public static int exercise8(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::value)
                .min(Comparator.comparing(Integer::valueOf))
                .orElse(-1);
    }
}
