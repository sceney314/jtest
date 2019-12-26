package test.son;

import lombok.Data;

/**
 * @author zhengzp
 * 2019-10-16 10:31
 */
@Data
public class People {
    private String name;

    private Integer age;

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
