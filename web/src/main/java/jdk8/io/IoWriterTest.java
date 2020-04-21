package jdk8.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 2020-04-14 16:46
 */
public class IoWriterTest {
    private static final char[] ArrayLetters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {
        char[] zifu = new char[]{'a','b','c','d'};
        try {
            BufferedReader reader = new BufferedReader(new CharArrayReader(zifu));
            System.out.println((char) reader.read());
            System.out.println((char) reader.read());
            reader.mark(1);
            System.out.println((char) reader.read());
            System.out.println((char) reader.read());
            System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }


        String reg = "\\d{1,32}";
        String id = "123456789012345678901234567890121";
        System.out.println(Pattern.matches(reg, id));
    }


}
