package patten.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke:" + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After invoke:" + method.getName());
        return object;
    }
}
