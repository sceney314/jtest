package threadnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-24 10:36
 * Description:
 */
public class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("elements");
    }

    public static int size() {
        return list.size();
    }
}
