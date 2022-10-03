package com.example.demo.data;

import com.example.demo.record.Transaction;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.data.TraderTestData.*;

public class TransactionTestData {
    public static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(BRIAN, 2011, 300),
            new Transaction(RAOUL, 2012, 1000),
            new Transaction(RAOUL, 2011, 400),
            new Transaction(MARIO, 2012, 710),
            new Transaction(MARIO, 2012, 700),
            new Transaction(ALAN, 2012, 950)
    );
}
