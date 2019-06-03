package patten.annotation;

import java.lang.annotation.*;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-03 14:09
 * Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
