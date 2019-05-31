package patten.proxy.cglib.filter;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import patten.proxy.cglib.callback.EngineerFix;
import patten.proxy.cglib.interceptor.EngineerInterceptor;
import patten.proxy.cglib.proxy.Engineer;

public class FilterTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Engineer.class);
        enhancer.setCallbackFilter(new EngineerFilter());
        enhancer.setCallbacks(new Callback[]{new EngineerInterceptor(), NoOp.INSTANCE, new EngineerFix()});
        Engineer engineer = (Engineer) enhancer.create();
        engineer.work();
        engineer.eat();
    }

}
