package patten.proxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EngineerInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(method.getName() + "方法调用前");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println(method.getName() + "方法调用后, result=" + object);
        return object;
    }
}
