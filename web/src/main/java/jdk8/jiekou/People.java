package jdk8.jiekou;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-17 11:07
 * Description:
 */
public interface People {

    int getAge();

    default String getName(){
        return "默认姓名";
    }
}
