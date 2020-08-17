package rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * 定时消息 producer（测试失败）
 * <p>
 * Date: 2020-08-04 15:38
 * Copyright (C), 2015-2020
 */
public class DelayProducer {
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
            LocalDateTime tu = LocalDateTime.now().plusSeconds(45);
            String con = "发送时间：" + LocalDateTime.now().toString() + "目标时间：" + tu.toString() + ", Hello delay rocket mq!";
            String key = "key" + System.currentTimeMillis();
            Message msg = new Message("ProducerDelayTopic", "delay",  key, con.getBytes(RemotingHelper.DEFAULT_CHARSET));
            msg.getProperty(MessageConst.PROPERTY_DELAY_TIME_LEVEL);
            Map<String, String> pmap = msg.getProperties();
            pmap.put("__STARTDELIVERTIME", tu.toEpochSecond(ZoneOffset.of("+8")) + "");
            SendResult result = producer.send(msg);

            // 消息结果
            System.out.println(result.toString());
        }

        // 关闭生产者
        producer.shutdown();
    }
}
