package com.example.modernjava.chapter11;

import java.util.Optional;

public record Person(Optional<Car> car, int age) {
}
