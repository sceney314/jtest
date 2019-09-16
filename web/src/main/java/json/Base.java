package json;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhengzp
 * 2019-08-25 16:35
 */
@Data
public class Base {
    private LocalDate localDate;

    public Base() {
        this.localDate = LocalDate.now();
    }
}
