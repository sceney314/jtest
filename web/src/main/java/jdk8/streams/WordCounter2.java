package jdk8.streams;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-12 20:26
 * Description:
 */
public class WordCounter2 implements Spliterator<Character> {

    private final String cont;
    private int currentChar = 0;

    public WordCounter2(String string) {
        this.cont = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(cont.charAt(currentChar++));
        return currentChar < cont.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = cont.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }

        for (int splitPos = currentSize / 2 + currentChar; splitPos < cont.length(); splitPos++) {
            if (Character.isWhitespace(cont.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounter2(cont.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }

        return null;
    }

    @Override
    public long estimateSize() {
        return cont.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
