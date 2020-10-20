package spi;

import java.util.ServiceLoader;

/**
 * 2020-06-04 19:05
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<ICar> cars = ServiceLoader.load(ICar.class);
        for (ICar car : cars){
            System.out.println(car.getCarName());
        }
    }
}
