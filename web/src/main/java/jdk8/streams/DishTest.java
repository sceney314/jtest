package jdk8.streams;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author zhengzp
 * 2019-07-31 20:07
 */
public class DishTest {
    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("宫保鸡丁", 334, "川", 3, false));
        dishes.add(new Dish("口水鸡", 331, "粤",5, false));
        dishes.add(new Dish("土豆丝", 43, "鲁", 4, true));
        dishes.add(new Dish("西红柿炒蛋", 124, "鲁", 42, false));
        dishes.add(new Dish("土豆牛肉", 743, "鲁", 61, false));
        dishes.add(new Dish("水煮鱼", 543, "湘", 6, false));
        dishes.add(new Dish("辣椒鸡蛋", 164, "湘", 61, true));

        Optional<Dish> option = dishes.stream().max(Comparator.comparing(Dish::getLevel));
        Dish max = option.get();
        System.out.println(max);

    }
}
