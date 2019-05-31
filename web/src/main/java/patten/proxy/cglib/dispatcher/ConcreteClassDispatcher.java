package patten.proxy.cglib.dispatcher;

import net.sf.cglib.proxy.Dispatcher;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcreteClassDispatcher implements Dispatcher {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher...");
        PropertyBean propertyBean = new PropertyBean();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        propertyBean.setKey("key =======>" + dateFormat.format(new Date()));
        propertyBean.setValue("value =======>" + dateFormat.format(new Date()));
        System.out.println("after Dispatcher...");
        return propertyBean;
    }

}
