package patten.proxy.cglib.lazy;

public class LazyBean {
    private String name;
    private int age;
    private PropertyBean propertyBean;
    private PropertyBean propertyBeanDispatcher;

    public LazyBean(String name, int age) {
        System.out.println("lazy bean init");
        this.name = name;
        this.age = age;
//        this.propertyBean = createPropertyBean();
//        this.propertyBeanDispatcher = createPropertyBeanDispatcher();
    }
}
