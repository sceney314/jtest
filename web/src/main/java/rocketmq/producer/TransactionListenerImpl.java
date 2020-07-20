package rocketmq.producer;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 事务消息监听器
 * <p>
 * Date: 2020-07-20 19:26
 * Copyright (C), 2015-2020
 */
public class TransactionListenerImpl implements TransactionListener {
    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

    // 当发送半消息成功时，我们使用 executeLocalTransaction 方法来执行本地事务。它返回前一节中提到的三个事务状态之一。
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        System.out.println("事务消息 - 执行本地事务");
        long tmp = System.currentTimeMillis() % 3;
        localTrans.put(msg.getTransactionId(), (int)tmp);

        if(tmp == 0L){
            System.out.println("事务消息 - 事务提交");
            return LocalTransactionState.COMMIT_MESSAGE;
        }else if (tmp == 1L){
            System.out.println("事务消息 - 事务回滚");
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        System.out.println("事务消息 - 事务未知");
        return LocalTransactionState.UNKNOW;
    }

    // checkLocalTransaction 方法用于检查本地事务状态，并回应消息队列的检查请求。它也是返回前一节中提到的三个事务状态之一。
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        Integer status = localTrans.get(msg.getTransactionId());
        if (null != status) {
            switch (status) {
                case 0:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case 1:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                case 2:
                    return LocalTransactionState.UNKNOW;
            }
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
