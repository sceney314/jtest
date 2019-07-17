package jdk8.optionals;

import java.util.Optional;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-17 15:04
 * Description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person());

        String name = person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

        System.out.println(name);
    }
}
