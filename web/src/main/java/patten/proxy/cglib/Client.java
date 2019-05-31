package patten.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        Callback[] callbacks = new Callback[]{new HelloInterceptor(), new HelloInterceptor2(), new TargetResultFixed()};
        enhancer.setCallbacks(callbacks);
//        enhancer.setCallbackTypes(new Class[]{HelloInterceptor.class, TargetResultFixed.class});

//        enhancer.setCallback(new TargetResultFixed());
//        enhancer.setCallbackType(TargetResultFixed.class);

        enhancer.setCallbackFilter(new HelloFilter());
        Hello hello = (Hello) enhancer.create();
        hello.sayHello();

        System.out.println("--------------");
        System.out.println(hello.hashCode());

//        byte[] classFile = ProxyGenerator.generateProxyClass("proxy.Hello", hello.getClass().getInterfaces());
//        String path = "/Users/king/Data/workspace/jtest/web/src/main/java/patten/proxy/cglib/ssss.class";
//        try{
//            FileOutputStream fos = new FileOutputStream(path);
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("代理类class文件写入成功");
//        } catch (Exception e) {
//            System.out.println("写文件错误");
//        }
    }
}
