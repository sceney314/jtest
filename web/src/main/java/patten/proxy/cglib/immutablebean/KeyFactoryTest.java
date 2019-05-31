package patten.proxy.cglib.immutablebean;

import net.sf.cglib.core.KeyFactory;

public class KeyFactoryTest {
    public static void main(String[] args) {
        SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(SampleKeyFactory.class);
        Object key = keyFactory.newInstance("foo", 42);
        Object key1 = keyFactory.newInstance("foo", 42);
        System.out.println(key.hashCode());
        System.out.println(key1.hashCode());
    }
}
