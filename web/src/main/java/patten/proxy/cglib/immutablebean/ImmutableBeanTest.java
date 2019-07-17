package patten.proxy.cglib.immutablebean;

import net.sf.cglib.beans.ImmutableBean;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-31 16:41
 * Description:
 */
public class ImmutableBeanTest {
    public static void main(String[] args) {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        //创建不可变类
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
        System.out.println(bean.getValue());
        //可以通过底层对象来进行修改
        bean.setValue("Hello world, again");
        System.out.println(bean.getValue());
        //直接修改将throw exception
        immutableBean.setValue("Hello cglib");
    }
}
