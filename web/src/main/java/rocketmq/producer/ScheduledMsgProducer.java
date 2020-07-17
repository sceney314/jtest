package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 延时消息生产者
 * <p>
 * Date: 2020-07-17 19:33
 * Copyright (C), 2015-2020
 */
public class ScheduledMsgProducer {
    public static void main(String[] args) throws Exception{

        // 创建指定分组名的生产者
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 连接 name server
        producer.setNamesrvAddr("localhost:9876");

        // 启动生产者
        producer.start();

        // 发送消息
        for (int k = 1; k < 5; k++){
            // 设置 topic、tag、key、内容
            Message msg = new Message("ScheduledMsgTopic", "scheduled",  "orderId:" + k, "Hello rocket scheduled mq!".getBytes(RemotingHelper.DEFAULT_CHARSET));

            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            // 每个等级时间定义在文件 MessageStoreConfig.java 中
            msg.setDelayTimeLevel(2);

            SendResult result = producer.send(msg);

            // 消息结果
            System.out.println(result.toString());
        }

        // 关闭生产者
        producer.shutdown();
    }
}
