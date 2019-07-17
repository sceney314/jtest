package patten.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-29 15:45
 * Description:
 */
public class HelloFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().equals("sayHello")){
            System.out.println("=====> Before filter:" + method.getName());
            System.out.println("*****  i don't know do what");
            System.out.println("=====> After filter:" + method.getName());
        }
        return 2;
    }
}
