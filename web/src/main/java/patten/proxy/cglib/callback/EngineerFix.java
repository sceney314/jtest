package patten.proxy.cglib.callback;

import net.sf.cglib.proxy.FixedValue;

public class EngineerFix implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        return "222";
    }
}
