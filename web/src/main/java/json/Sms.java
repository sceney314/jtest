package json;

import lombok.Data;

/**
 * @author zhengzp
 * 2019-08-19 19:54
 */
@Data
public class Sms extends Base{
    private Integer id;

    private String mobile;

    private String content;

}
