package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量消息生产者
 * <p>
 * Date: 2020-07-20 19:18
 * Copyright (C), 2015-2020
 */
public class BatchMsgProducer {
    public static void main(String[] args) throws Exception {
        // 创建指定分组名的生产者
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 连接 name server
        producer.setNamesrvAddr("localhost:9876");

        // 启动生产者
        producer.start();

        // 发送消息
        List<Message> msgs = new ArrayList<>();
        for (int i = 5; i >= 0; i--){
            // 设置 topic、tag、key、内容
            Message msg = new Message("BatchTest", "batch",  "orderId:" + i, "Hello rocket mq!".getBytes(RemotingHelper.DEFAULT_CHARSET));
            msgs.add(msg);
        }

        SendResult result = producer.send(msgs);

        // 消息结果
        System.out.println(result.toString());


        // 关闭生产者
        producer.shutdown();
    }
}
