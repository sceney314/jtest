package jdk8.streams;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-12 20:20
 * Description:
 */
public class WordTest {
    public static void main(String[] args) {
        final String SENTENCE =
                " Nel   mezzo del cammin  di nostra  vita " +
                        "mi  ritrovai in una  selva oscura" +
                        " ché la  dritta via era   smarrita ";
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");


        Spliterator<Character> spliterator = new WordCounter2(SENTENCE);
        Stream<Character> st = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(st) + " words");
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate,  WordCounter::combine);
        return wordCounter.getCounter();
    }
}
