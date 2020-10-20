package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 有序消息消费者
 * <p>
 * Date: 2020-07-17 19:24
 * Copyright (C), 2015-2020
 */
public class OrderConsumer {
    public static void main(String[] args) throws Exception{
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");

        // 设置 Name Server 地址
        consumer.setNamesrvAddr("127.0.0.1:9876");

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("OrderMsgTopic", "order");

        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            System.out.println("消息上下文 Context=" + context.getMessageQueue());
            for (MessageExt ext : msgs){
                System.out.println("消息:" + ext);

                StringBuilder sb = new StringBuilder();
                try {
                    sb.append("msgId=")
                            .append(ext.getMsgId())
                            .append(", queueId=")
                            .append(ext.getQueueId())
                            .append(", keys=")
                            .append(ext.getKeys())
                            .append(", msgBody=")
                            .append(new String(ext.getBody(), RemotingHelper.DEFAULT_CHARSET));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("人为解析消息:" + sb.toString());
                System.out.println("");
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });

        // 消费者启动
        consumer.start();

        System.out.printf("Order Consumer Started.%n");
    }
}
