package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description: 单向发送消息，这种方式主要用在不特别关心发送结果的场景，例如日志发送。
 * <p>
 * Date:     2020-07-17 14:58
 * Copyright (C), 2015-2020
 */
public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 设置NameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        // 启动Producer实例
        producer.start();

        // 发送消息
        for (int k = 1; k < 5; k++){
            Message msg = new Message("OnewayTopicTest", "oneway",  "orderId:" + k, "Hello rocket one way mq !".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(msg);
        }

        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
