package jdk8.streams;

import lombok.Data;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        People p1 = new People("test1", "北京", 12);
        People p2 = new People("test2", "北京", 43);
        People p3 = new People("test3", "山东", 53);
        People p4 = new People("test4", "山东", 24);
        People p5 = new People("test5", "山东", 53);
        People p6 = new People("test6", "河北", 87);

        List<People> peopleList = Arrays.asList(p1, p2 , p3, p4, p5, p6);
        peopleList.stream().collect(Collectors.groupingBy(People::getProvence)).forEach((k, v) -> {
            System.out.println("key=" + k + ", value=" + v.stream().mapToInt(People::getAge).sum());
        });

        Map<String, Integer> ageMap = peopleList.stream()
                .collect(Collectors.groupingBy(People::getProvence, Collectors.reducing(0, People::getAge, Integer::sum)));
        System.out.println(ageMap);

        // Map<String, Product> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Product::getNum)), Optional::get)));
        Map<String, People> pmap = peopleList.stream() .collect(Collectors.toMap(People::getProvence, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(People::getAge))));
        System.out.println(pmap);


        Optional<Map.Entry<String, Integer>> result = ageMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));

        String key = "";
        if (result.isPresent()){
            key = result.get().getKey();
        }
        System.out.println(ageMap.get(key));
    }

    @Data
    private static class People{
        private String name;

        private String provence;

        private int age;

        public People(String name, String provence, int age) {
            this.name = name;
            this.provence = provence;
            this.age = age;
        }
    }
}
