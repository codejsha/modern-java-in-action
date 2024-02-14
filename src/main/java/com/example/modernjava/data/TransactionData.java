package com.example.modernjava.data;

import com.example.modernjava.record.Transaction;

import java.util.List;

import static com.example.modernjava.data.TraderData.*;

public class TransactionData {
    public static final List<Transaction> TRANSACTIONS = List.of(
            new Transaction(BRIAN, 2011, 300),
            new Transaction(RAOUL, 2012, 1000),
            new Transaction(RAOUL, 2011, 400),
            new Transaction(MARIO, 2012, 710),
            new Transaction(MARIO, 2012, 700),
            new Transaction(ALAN, 2012, 950)
    );

    public static final List<String> REFERENCE_CODES = List.of("a12", "C14", "b13");
}
