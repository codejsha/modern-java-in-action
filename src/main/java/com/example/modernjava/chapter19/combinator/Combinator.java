package com.example.modernjava.chapter19.combinator;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Combinator {
    public static void main(String[] args) {
        log.info(repeat(3, (Integer x) -> 2 * x).apply(10).toString());
    }

    static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return x -> g.apply(f.apply(x));
    }

    static <A> Function<A, A> repeat(int n, Function<A, A> f) {
        return n == 0 ? x -> x : compose(f, repeat(n - 1, f));
    }
}
