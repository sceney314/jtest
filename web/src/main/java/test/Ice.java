package test;

import lombok.Data;

@Data
public class Ice extends Water {
    static {
        biz.add(1);
        biz.add(2);
        biz.add(3);
    }

}
