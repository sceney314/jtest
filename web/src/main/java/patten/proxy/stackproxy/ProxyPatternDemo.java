package patten.proxy.stackproxy;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-29 11:25
 * Description:
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
