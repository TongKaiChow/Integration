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
import java.util.concurrent.ExecutionException;

@Order(101)
@Service
@Slf4j
@RequiredArgsConstructor
public class MqTxProducerProcessor implements ProducerProcessor {
    private final RocketMQCustomProperties rocketMQCustomProperties;

    @Override
    public Message buildMsg(byte[] body, String tag, String topic, Long delayMillSecond, String messageGroup) {
        MessageBuilder builder = new MessageBuilderImpl();
        tag = Objects.isNull(tag) ? rocketMQCustomProperties.getNormalTag() : tag;
        topic = Objects.isNull(topic) ? rocketMQCustomProperties.getNormalTopic() : topic;
        final String keys = rocketMQCustomProperties.getNormalKeys() + "_" + System.currentTimeMillis();
        return builder.setTopic(topic).setTag(tag).setKeys(keys).setBody(body).build();
    }

    @Override
    public SendReceipt sendMsg(Producer producer, Message msg) throws ClientException {
        return null;
    }

    @Override
    public SendReceipt sendTxMsg(Producer producer, Message msg) throws ClientException {
        return producer.send(msg, producer.beginTransaction());
    }

    /**
     * 异步
     *
     * @param producer
     * @param msg
     * @return 消息发送结果，CompletableFuture可以设置立即、多长时间内返回、发送成功后返回(默认)
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public SendReceipt sendAsyncMsg(Producer producer, Message msg) throws ExecutionException, InterruptedException {
        return null;
    }
}
