package com.example.modernjava.chapter11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CarInsuranceProcessingTest {
    private Insurance cambridgeInsurance;
    private Car car1;
    private Car car2;
    private Person person1;
    private Person person2;
    private Person person3;

    @BeforeEach
    void setUp() {
        cambridgeInsurance = new Insurance("CambridgeInsurance");
        car1 = new Car(Optional.of(cambridgeInsurance));
        car2 = new Car(Optional.empty());
        person1 = new Person(Optional.of(car1), 20);
        person2 = new Person(Optional.empty(), 25);
        person3 = new Person(Optional.of(car2), 30);
    }

    @Test
    void testGetCarInsuranceName1() {
        final var result1 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person1));
        assertNotNull(result1);
        assertEquals(cambridgeInsurance.name(), result1);

        final var result2 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person2));
        assertNotNull(result2);
        assertEquals("Unknown", result2);

        final var result3 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person3));
        assertNotNull(result3);
        assertEquals("Unknown", result3);
    }

    @Test
    void testGetCarInsuranceName2() {
        final var result1 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person1), 18);
        assertNotNull(result1);
        assertEquals(cambridgeInsurance.name(), result1);

        final var result2 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person2), 18);
        assertNotNull(result2);
        assertEquals("Unknown", result2);

        final var result3 = CarInsuranceProcessing.getCarInsuranceName(Optional.ofNullable(person3), 18);
        assertNotNull(result3);
        assertEquals("Unknown", result3);
    }

    @Test
    void testGetCarInsuranceNames() {
        final var result = CarInsuranceProcessing.getCarInsuranceNames(List.of(person1, person2, person3));
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(cambridgeInsurance.name(), result.iterator().next());
    }

    @Test
    void testNullSafeFindCheapestInsurance() {
        final var result1 = CarInsuranceProcessing.nullSafeFindCheapestInsurance(
                Optional.ofNullable(person1), Optional.ofNullable(car1));
        assertNotNull(result1);
        assertNotEquals(Optional.empty(), result1);

        final var result2 = CarInsuranceProcessing.nullSafeFindCheapestInsurance(
                Optional.ofNullable(person2), Optional.empty());
        assertNotNull(result2);
        assertEquals(Optional.empty(), result2);

        final var result3 = CarInsuranceProcessing.nullSafeFindCheapestInsurance(
                Optional.ofNullable(person3), Optional.ofNullable(car1));
        assertNotNull(result3);
        assertNotEquals(Optional.empty(), result3);
    }
}
