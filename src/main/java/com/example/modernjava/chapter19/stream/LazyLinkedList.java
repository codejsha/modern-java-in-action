package com.example.modernjava.chapter19.stream;

import com.example.modernjava.chapter19.stream.GeneralLinkedList.MyList;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
import java.util.function.Supplier;

@Slf4j
public class LazyLinkedList {
    public static void main(String[] args) {
        var numbers = from(2);
        final int two = numbers.head();
        final int three = numbers.tail().head();
        final int four = numbers.tail().tail().head();
        log.info(two + " " + three + " " + four);

        numbers = from(2);
        final int prime_two = primes(numbers).head();
        final int prime_three = primes(numbers).tail().head();
        final int prime_five = primes(numbers).tail().tail().head();
        log.info(prime_two + " " + prime_three + " " + prime_five);
    }

    /**
     * Create an infinite lazy list of numbers starting from n.
     *
     * @param n the start number
     * @return the lazy list
     */
    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    /**
     * Create an infinite lazy list of prime numbers.
     *
     * @param numbers the numbers
     * @return the lazy list
     */
    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail().filter(n -> n % numbers.head() != 0)));
    }

    static <T> void printAll(MyList<T> numbers) {
        if (numbers.isEmpty()) {
            return;
        }
        log.info(numbers.head().toString());
        printAll(numbers.tail());
    }

    public static class LazyList<T> implements MyList<T> {

        final T head;
        final Supplier<MyList<T>> tail;

        public LazyList(T head, Supplier<MyList<T>> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail.get();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return isEmpty() ? this : p.test(head()) ? new LazyList<>(head(), () -> tail().filter(p)) : tail().filter(p);
        }
    }
}
