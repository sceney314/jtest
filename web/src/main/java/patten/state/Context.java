package patten.state;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境类
 */
public class Context {

    private static Map<String, State> state = new HashMap<>();
    static{
        state.put("A", new ConcreteStateA());
        state.put("B", new ConcreteStateB());
    }

    //对请求做处理
    public void Handle(String status) {
        state.get(status).Handle(this);
    }

}
