package com.ztk.mq.processer.producer.impl;

import com.ztk.mq.processer.producer.ProducerProcessor;
import com.ztk.mq.properties.RocketMQCustomProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.message.MessageBuilder;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.apache.rocketmq.client.java.message.MessageBuilderImpl;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 延迟消费生产者
 */
@Order(101)
@Service
@Slf4j
@RequiredArgsConstructor
public class MqFifoProducerProcessor implements ProducerProcessor {
    private final RocketMQCustomProperties rocketMQCustomProperties;

    /**
     * @param body            消息内容
     * @param tag             标识-no necessary
     * @param topic           主题
     * @param delayMillSecond 延迟-no necessary
     * @param messageGroup    消息组-no necessary
     * @return
     * @desc 构建消息
     */
    @Override
    public Message buildMsg(byte[] body, String tag, String topic, Long delayMillSecond, String messageGroup) {
        MessageBuilder builder = new MessageBuilderImpl();
        tag = Objects.isNull(tag) ? rocketMQCustomProperties.getFifoTag() : tag;
        topic = Objects.isNull(topic) ? rocketMQCustomProperties.getFifoTopic() : topic;
        messageGroup = Objects.isNull(messageGroup) ? rocketMQCustomProperties.getFifoMessageGroup() : messageGroup;
        final String keys = rocketMQCustomProperties.getFifoKeys() + "_" + System.currentTimeMillis();
        return builder.setTopic(topic)
                .setTag(tag)
                .setKeys(keys)
                .setMessageGroup(messageGroup)
                .setBody(body).build();
    }


    @Override
    public SendReceipt sendMsg(Producer producer, Message msg) throws ClientException {
        return producer.send(msg);
    }

    @Override
    public SendReceipt sendTxMsg(Producer producer, Message msg) throws ClientException {
      return null;
    }

    @Override
    public SendReceipt sendAsyncMsg(Producer producer, Message msg) throws ExecutionException, InterruptedException {
        return null;

    }
}
