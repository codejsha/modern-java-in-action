package com.example.demo.chapter11;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CarInsuranceProcessing {
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::car)
                .flatMap(Car::insurance)
                .map(Insurance::name)
                .orElse("Unknown");
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.age() >= minAge)
                .flatMap(Person::car)
                .flatMap(Car::insurance)
                .map(Insurance::name)
                .orElse("Unknown");
    }

    public static Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::car)
                .map(optCar -> optCar.flatMap(Car::insurance))
                .map(optInsurance -> optInsurance.map(Insurance::name))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

        // if (person.isPresent() && car.isPresent()) {
        //     return Optional.of(findCheapestInsurance(person.get(), car.get()));
        // } else {
        //     return Optional.empty();
        // }
    }

    public static Insurance findCheapestInsurance(Person person, Car car) {
        // dummy
        return car.insurance().orElse(new Insurance("Unknown"));
    }
}
