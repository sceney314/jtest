package patten.proxy.cglib.lazyloader;

public class LazyloaderTest {

    public static void main(String[] args) {
        LoaderBean loader = new LoaderBean();
        //访问延迟加载对象
        PropertyBean propertyBean = loader.getPropertyBean();
        //当再次访问延迟加载对象时,就不会再执行回调了
        System.out.println(propertyBean.getPropertyName());
    }

}
