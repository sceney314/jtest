package test.keywords;

import lombok.Data;

/**
 * 2020-03-09 06:34
 */
@Data
public class User {
    private String name;

    private Integer age;

    transient private String sex;
}
