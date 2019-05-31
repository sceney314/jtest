package patten.proxy.cglib.immutablebean;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BulkBean;

public class BeanCopierTest {
    public static void main(String[] args) {
        //设置为true，则使用converter
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);
        SampleBean myBean = new SampleBean();
        myBean.setValue("Hello cglib");
        OtherSampleBean otherBean = new OtherSampleBean();
        //设置为true，则传入converter指明怎么进行转换
        copier.copy(myBean, otherBean, null);
        System.out.println(otherBean.getValue());


        System.out.println("***********************************");
        // 相比于BeanCopier，BulkBean将copy的动作拆分为getPropertyValues和setPropertyValues两个方法，允许自定义处理属性
        BulkBean bulkBean = BulkBean.create(SampleBean.class, new String[]{"getValue"}, new String[]{"setValue"}, new Class[]{String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        System.out.println(bulkBean.getPropertyValues(bean).length);
        System.out.println(bulkBean.getPropertyValues(bean)[0]);
        bulkBean.setPropertyValues(bean, new Object[]{"Hello cglib"});
        System.out.println(bean.getValue());

    }
}
