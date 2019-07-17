package patten.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-29 17:32
 * Description:
 */
public class HelloInterceptor2 implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before 2 invoke:" + method.getName());
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("After 2 invoke:" + method.getName());
        return object;
    }
}
