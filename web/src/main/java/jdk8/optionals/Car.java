package jdk8.optionals;

import java.util.Optional;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-17 15:04
 * Description:
 */
public class Car {
    private Insurance insurance;

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}
