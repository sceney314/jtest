package patten.proxy.cglib.callback;

import net.sf.cglib.proxy.FixedValue;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-05-31 11:33
 * Description: 固定值callback
 */
public class EngineerFix implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        return "222";
    }
}
