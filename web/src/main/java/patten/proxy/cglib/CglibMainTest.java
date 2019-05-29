package patten.proxy.cglib;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-05-29 11:23
 * Description:
 */
public class CglibMainTest {
    public static void main(String[] args) {
        // 生成 Cglib 代理类
        Engineer engineerProxy = (Engineer) CglibProxy.getProxy(new Engineer());
        // 调用相关方法
        engineerProxy.eat();
    }
}
