package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 * 同步性消息
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        // 创建指定分组名的生产者
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 连接 name server
        producer.setNamesrvAddr("localhost:9876");

        // 启动生产者
        producer.start();

        // 发送消息
        for (int i = 5; i >= 0; i--){
            // 设置 topic、tag、key、内容
            Message msg = new Message("TopicTest", "sync",  "orderId:" + i, "Hello rocket mq!".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(msg);

            // 消息结果
            System.out.println(result.toString());
        }

        // 关闭生产者
        producer.shutdown();
    }
}
