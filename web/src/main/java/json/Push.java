package json;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author zhengzp
 * 2019-08-19 19:56
 */
@Data
public class Push {
    @JsonIgnore
    private String content;

    private Sms sms;
}
