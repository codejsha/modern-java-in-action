package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class TemplateMethodPattern {
    public static void main(String[] args) {
        new TemplateMethodPattern().processCustomer(1337, (customer) -> log.info("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        final var customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }

    // dummy
    public static class Customer {
    }

    // dummy
    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
