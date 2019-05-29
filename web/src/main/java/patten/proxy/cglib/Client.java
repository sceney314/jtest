package patten.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new HelloInterceptor());
        enhancer.setCallbackFilter(new HelloFilter());
        Hello hello = (Hello) enhancer.create();
        hello.sayHello();

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
