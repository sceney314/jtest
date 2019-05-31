package patten.proxy.cglib.im;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import patten.proxy.cglib.proxy.Engineer;

import java.lang.reflect.Method;

public class TestInterfaceMaker {
    public static void main(String[] args) {
        InterfaceMaker interfaceMaker = new InterfaceMaker();

        //抽取某个类的方法生成接口方法
        interfaceMaker.add(Engineer.class);
        Class<?> targetInterface = interfaceMaker.create();
        for (Method method : targetInterface.getMethods()) {
            System.out.println(method.getName());
        }

        //接口代理并设置代理接口方法拦截
        Object object = Enhancer.create(Engineer.class, new Class[]{targetInterface}, new MethodInterceptor(){
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
                if (method.getName().equals("eat")) {
                    System.out.println("filter eat ");
                    return "方法 eat";
                }

                if (method.getName().equals("pay")) {
                    System.out.println("filter pay ");
                    return methodProxy.invokeSuper(obj, args);
                }

                if (method.getName().equals("age")) {
                    System.out.println("filter method3 ");
                    return 3333;
                }

                return "default";
            }
        });

        try {
            Method targetMethod1 = object.getClass().getMethod("eat");
            targetMethod1.invoke(object);

            Method targetMethod = object.getClass().getMethod("pay", new Class[]{String.class});
            System.out.println(targetMethod.invoke(object, new Object[]{"哈哈哈哈哈"}));

            Method targetMethod2 = object.getClass().getMethod("age", new Class[]{int.class});
            System.out.println(targetMethod2.invoke(object, new Object[]{12}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
