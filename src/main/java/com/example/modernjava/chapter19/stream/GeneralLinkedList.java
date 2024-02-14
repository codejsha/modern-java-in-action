package com.example.modernjava.chapter19.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class GeneralLinkedList {
    public static void main(String[] args) {
        final MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
        log.info(l.head().toString());
    }

    public interface MyList<T> {
        T head();

        MyList<T> tail();

        default boolean isEmpty() {
            return true;
        }

        MyList<T> filter(Predicate<T> p);
    }

    public static class MyLinkedList<T> implements MyList<T> {
        final T head;
        final MyList<T> tail;

        public MyLinkedList(T head, MyList<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return isEmpty() ? this : p.test(head()) ? new MyLinkedList<>(head(), tail().filter(p)) : tail().filter(p);
        }
    }

    public static class Empty<T> implements MyList<T> {
        @Override
        public T head() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> tail() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return this;
        }
    }
}
