package patten.proxy.cglib.dispatcher;

import net.sf.cglib.proxy.Enhancer;

public class LazyBean {
    private String name;
    private int age;
    private PropertyBean propertyBeanDispatcher;

    public LazyBean(String name, int age) {
        this.name = name;
        this.age = age;
        this.propertyBeanDispatcher = createPropertyBeanDispatcher();
    }
    private PropertyBean createPropertyBeanDispatcher() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PropertyBean.class);
        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class, new ConcreteClassDispatcher());
        return pb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PropertyBean getPropertyBeanDispatcher() {
        return propertyBeanDispatcher;
    }

    public void setPropertyBeanDispatcher(PropertyBean propertyBeanDispatcher) {
        this.propertyBeanDispatcher = propertyBeanDispatcher;
    }

}
