package patten.proxy.cglib.filter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class EngineerFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (-1 != "work|eat".indexOf(method.getName())){
            System.out.println(method.getName() + "，欢迎来到过滤器");
        }
        return 2;
    }
}
