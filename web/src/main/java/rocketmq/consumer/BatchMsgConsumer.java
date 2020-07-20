package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 批量消息消费者
 * <p>
 * Date: 2020-07-20 19:20
 * Copyright (C), 2015-2020
 */
public class BatchMsgConsumer {
    public static void main(String[] args) throws Exception{
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");

        // 设置 Name Server 地址
        consumer.setNamesrvAddr("127.0.0.1:9876");

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("BatchTest", "batch");

        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            int ackIndex = context.getAckIndex();
            MessageQueue queue = context.getMessageQueue();
            int delayLevel = context.getDelayLevelWhenNextConsume();
            System.out.println("ackIndex=" + ackIndex + ", delayLevel=" + delayLevel + ", BrokerName=" + queue.getBrokerName() + ", getTopic=" + queue.getTopic() + ", getQueueId=" + queue.getQueueId());
            for (MessageExt ext : msgs){
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append("msgId=")
                            .append(ext.getMsgId())
                            .append(", msgBody=")
                            .append(new String(ext.getBody(), RemotingHelper.DEFAULT_CHARSET));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("消息:" + ext);
                System.out.println("人为解析消息:" + sb.toString());
                System.out.println("");
            }

            // 标记该消息已经被成功消费
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
