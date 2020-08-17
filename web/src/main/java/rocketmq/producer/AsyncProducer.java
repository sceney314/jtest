package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 发送异步消息
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception{
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        // 设置NameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        // 启动Producer实例
        producer.start();

        // 异步发送失败重试次数
        producer.setRetryTimesWhenSendAsyncFailed(1);

        // 发送消息
        for (int i = 10; i < 15; i++){
            Message msg = new Message("AsyncTopicTest", "async",  "orderId:" + i, "Hello rocket async mq 2!".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("异步消息发送成功：" + sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println("消息发送异常：" + e.getMessage());
                }
            });
        }

        // 等一会，让消息异步发送成功
        Thread.sleep(5000);

        // 关闭生产者
        producer.shutdown();
    }
}
