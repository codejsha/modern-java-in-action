package com.example.demo.chapter11;

import java.util.Optional;

public record Person(Optional<Car> car, int age) {
}
