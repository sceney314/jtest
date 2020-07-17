package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 顺序消息生产者
 * <p>
 * Date: 2020-07-17 18:58
 * Copyright (C), 2015-2020
 */
public class OrderProducer {
    public static void main(String[] args) throws Exception{
        // 创建指定分组名的生产者
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 连接 name server
        producer.setNamesrvAddr("localhost:9876");

        // 启动生产者
        producer.start();

        // 发送消息
        for(int i = 11; i < 16; i++){
            Message msg = new Message("OrderMsgTopic", "order",  "order-Id:" + i, "Hello rocket mq!".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(msg, (mqs, msg1, arg) -> {
                // 消息队列选择标识
                int id = (int) arg;
                // 选择队列方法
                int index = id % mqs.size();
                // 选择队列
                return mqs.get(index);
            }, i);

            // 消息结果
            System.out.println(result.toString());
        }

        // 关闭生成者
        producer.shutdown();
    }
}
