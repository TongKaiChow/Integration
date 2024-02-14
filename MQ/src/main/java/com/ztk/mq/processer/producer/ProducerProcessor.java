package com.ztk.mq.processer.producer;

import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;

import java.util.concurrent.ExecutionException;

public interface ProducerProcessor {
    /**
     * @param body            消息内容-necessary
     * @param tag             标识-no necessary，同主题区分业务
     * @param topic           主题-necessary
     * @param delayMillSecond 延迟-no necessary，延迟主题才使用
     * @param messageGroup    消息组-no necessary，同msgG会在同一消息queue，且只有在顺序topic中有用，且生产者单一，且串行发送，才能保证消息生产有序
     * @return message消息体
     * @desc 构建消息
     */
    Message buildMsg(byte[] body, String tag, String topic, Long delayMillSecond, String messageGroup);

    /**
     * 同步发送消息
     *
     * @param producer
     * @param msg
     * @return 消息发送结果
     * @throws ClientException
     */
    SendReceipt sendMsg(Producer producer, Message msg) throws ClientException;

    /**
     * 事物发送消息
     *
     * @param producer
     * @param msg
     * @return 消息发送结果
     * @throws ClientException
     */
    SendReceipt sendTxMsg(Producer producer, Message msg) throws ClientException;

    /**
     * 异步
     *
     * @param producer
     * @param msg
     * @return 消息发送结果，CompletableFuture可以设置立即、多长时间内返回、发送成功后返回(默认)
     * @throws ExecutionException
     * @throws InterruptedException
     */
    SendReceipt sendAsyncMsg(Producer producer, Message msg) throws ExecutionException, InterruptedException;
}
