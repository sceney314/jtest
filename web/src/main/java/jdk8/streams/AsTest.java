package jdk8.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-06 20:05
 * Description:
 */
public class AsTest {
    public static void main(String[] args) {
        Integer[] n = new Integer[]{1,3,54,67,7,4,86,9};
        List<Integer> numbers = Arrays.asList(n);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();

        System.out.println(firstSquareDivisibleByThree);
        System.out.println(firstSquareDivisibleByThree.get());

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> trans = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .collect(Collectors.toList());
        System.out.println(trans);


        List<String> citys = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(citys);


        transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader));

    }
}
