package patten.proxy.cglib.interceptor;

import net.sf.cglib.proxy.Enhancer;
import patten.proxy.cglib.proxy.Engineer;

import java.io.FileOutputStream;
import java.io.InputStream;

public class InterceptorTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Engineer.class);
        enhancer.setCallback(new EngineerInterceptor());
        enhancer.setCallbackType(EngineerInterceptor.class);
        Engineer engineer = (Engineer)enhancer.create();
        engineer.work();
        engineer.eat();

//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        InputStream inputStream = loader.getResourceAsStream(engineer.getClass().getName());
//        try {
//            String name = engineer.getClass().getSimpleName();
//            String path = "/Users/king/Data/workspace/jtest/web/src/main/java/patten/proxy/cglib/interceptor/" + name + ".class";
//            FileOutputStream fos = new FileOutputStream(path);
//            while (true){
//                byte[] data = new byte[1024];
//                int lenth = inputStream.read(data);
//                fos.write(data);
//                if (lenth == -1){
//                    break;
//                }
//            }
//            fos.flush();
//            fos.close();
//            System.out.println("write success");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
