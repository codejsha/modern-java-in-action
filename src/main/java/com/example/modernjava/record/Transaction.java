package com.example.modernjava.record;

public record Transaction(
        Trader trader,
        int year,
        int value) {
}
