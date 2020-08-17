package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.time.LocalDateTime;

/**
 * 定时消息消费
 * <p>
 * Date: 2020-08-04 15:52
 * Copyright (C), 2015-2020
 */
public class DelayConsumer {
    public static void main(String[] args) throws Exception{
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");

        // 设置 Name Server 地址
        consumer.setNamesrvAddr("127.0.0.1:9876");

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("ProducerDelayTopic", "delay");

        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt ext : msgs){
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(", keys=")
                            .append(ext.getKeys())
                            .append(", msgBody=")
                            .append(new String(ext.getBody(), RemotingHelper.DEFAULT_CHARSET));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now().toString() + ", 人为解析消息:" + sb.toString());
            }

            // 标记该消息已经被成功消费
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
