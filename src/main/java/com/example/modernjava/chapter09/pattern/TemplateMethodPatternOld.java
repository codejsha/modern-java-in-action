package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TemplateMethodPatternOld {
    public static void main(String[] args) {
        new TemplateMethodPatternOld() {
            @Override
            protected void makeCustomerHappy(Customer customer) {
                log.info("Hello!");
            }
        }.processCustomer(1337);
    }

    public void processCustomer(int id) {
        final var customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    protected abstract void makeCustomerHappy(Customer customer);

    // dummy
    private static class Customer {
    }

    // dummy
    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
