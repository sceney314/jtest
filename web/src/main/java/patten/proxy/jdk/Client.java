package patten.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //真实对象
        Subject realSubject =  new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //代理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", proxyClass.getClass().getInterfaces());
        String path = "/Users/king/Data/workspace/jtest/web/src/main/java/patten/proxy/jdk/ProxySubject.class";
        try{
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }

        proxyClass.sellBooks();

        proxyClass.speak();
    }
}
