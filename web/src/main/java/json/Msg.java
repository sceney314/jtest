package json;

import lombok.Data;

/**
 * @author zhengzp
 * 2019-08-19 19:53
 */
@Data
public class Msg<T> {
    private Integer id;

    private T t;
}
