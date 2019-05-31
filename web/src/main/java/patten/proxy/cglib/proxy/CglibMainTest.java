package patten.proxy.cglib.proxy;

import patten.proxy.cglib.CglibProxy;

public class CglibMainTest {
    public static void main(String[] args) {
        // 生成 Cglib 代理类
        Engineer engineerProxy = (Engineer) CglibProxy.getProxy(new Engineer());
        // 调用相关方法
        engineerProxy.eat();
        engineerProxy.work();
        engineerProxy.pay("sss");
    }
}
