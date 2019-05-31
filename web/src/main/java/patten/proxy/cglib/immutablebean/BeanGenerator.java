package patten.proxy.cglib.immutablebean;

import java.lang.reflect.Method;

public class BeanGenerator {
    public static void main(String[] args) {
        net.sf.cglib.beans.BeanGenerator beanGenerator = new net.sf.cglib.beans.BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        try {
            Method setter = myBean.getClass().getMethod("setValue", String.class);
            setter.invoke(myBean, "Hello cglib");
            Method getter = myBean.getClass().getMethod("getValue");
            System.out.println(getter.invoke(myBean));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
