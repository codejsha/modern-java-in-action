package com.example.demo.data;

import com.example.demo.record.Trader;

import java.util.List;

public class TraderTestData {
    public static final Trader RAOUL = new Trader("Raoul", "Cambridge");
    public static final Trader MARIO = new Trader("Mario", "Milan");
    public static final Trader ALAN = new Trader("Alan", "Cambridge");
    public static final Trader BRIAN = new Trader("Brian", "Cambridge");

    public static final List<Trader> TRADER_LIST = List.of(RAOUL, MARIO, ALAN, BRIAN);
}