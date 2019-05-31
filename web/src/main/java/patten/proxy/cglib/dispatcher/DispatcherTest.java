package patten.proxy.cglib.dispatcher;

public class DispatcherTest {
    public static void main(String[] args) {
        LazyBean bean = new LazyBean("张三", 23);
        PropertyBean propertyBean = bean.getPropertyBeanDispatcher();
        System.out.println(propertyBean.getKey());
        System.out.println(propertyBean.getValue());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("-------------------");
        PropertyBean bean1 = bean.getPropertyBeanDispatcher();
        System.out.println(bean1.getKey());
        System.out.println(bean1.getValue());
        System.out.println("-------------------");
        System.out.println(propertyBean.hashCode());
        System.out.println(bean1.hashCode());
    }
}
