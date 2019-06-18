package jdk8.optionals;

import java.util.Optional;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-17 15:03
 * Description:
 */
public class Person {
    private Car car;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }
}
