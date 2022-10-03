package com.example.demo.record;

public record Transaction(
        Trader trader,
        int year,
        int value) {
}
