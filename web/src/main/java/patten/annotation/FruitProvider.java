package patten.annotation;

import java.lang.annotation.*;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-03 14:10
 * Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    // 编号
    int id() default -1;

    // 名字
    String name() default "";

    // 地址
    String address() default "";
}
