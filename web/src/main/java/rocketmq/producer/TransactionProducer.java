package rocketmq.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.*;

/**
 * 事务消息生产者
 * <p>
 * Date: 2020-07-20 19:25
 * Copyright (C), 2015-2020
 */
public class TransactionProducer {
    public static void main(String[] args) throws Exception{
        TransactionListener listener = new TransactionListenerImpl();

        TransactionMQProducer producer = new TransactionMQProducer("ProducerGroupName");

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000), r -> {
            Thread thread = new Thread(r);
            thread.setName("client-transaction-msg-check-thread");
            return thread;
        });

        // 连接 name server
        producer.setNamesrvAddr("localhost:9876");

        // 设置周期调用
        producer.setExecutorService(executorService);
        // 设置监听器
        producer.setTransactionListener(listener);
        //生产者启动
        producer.start();

        for (int i = 1; i < 11; i++){
            long unix = System.currentTimeMillis();
            String content = "Hello rocket transaction mq!" + unix;
            String key = "tran" + unix;
            Message msg = new Message("TransactionTopic", "tran", key, content.getBytes(RemotingHelper.DEFAULT_CHARSET));

            // 发送消息
            SendResult result = producer.sendMessageInTransaction(msg, null);
            // 消息结果
            System.out.println(result.toString());
        }

        TimeUnit.SECONDS.sleep(10);

        // 关闭生产者
        producer.shutdown();
    }
}
