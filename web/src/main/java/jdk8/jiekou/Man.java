package jdk8.jiekou;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-17 11:45
 * Description:
 */
public interface Man extends People {
    String sex();

    default String getName(){
        return "男性-默认姓名";
    }
}
