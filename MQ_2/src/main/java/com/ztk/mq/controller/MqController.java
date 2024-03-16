package com.ztk.mq.controller;

import com.aliyun.core.utils.StringUtils;
import com.ztk.mq.dto.DelayMsgRequestDto;
import com.ztk.mq.dto.FifoMsgRequestDto;
import com.ztk.mq.dto.NormalMsgRequestDto;
import com.ztk.mq.dto.TxMsgRequestDto;
import com.ztk.mq.processer.producer.impl.MqDelayProducerProcessor;
import com.ztk.mq.processer.producer.impl.MqFifoProducerProcessor;
import com.ztk.mq.processer.producer.impl.MqNormalProducerProcessor;
import com.ztk.mq.processer.producer.impl.MqTxProducerProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mq")
public class MqController {
//    private final MqDelayProducerProcessor mqDelayProducerProcessor;
//    private final Producer delayProducer;
//
//    private final MqFifoProducerProcessor mqFifoProducerProcessor;
//    private final Producer fifoProducer;
//
//    private final MqNormalProducerProcessor mqNormalProducerProcessor;
//    private final Producer normalProducer;
//
//    private final MqTxProducerProcessor mqTxProducerProcessor;
//    private final Producer txProducer;
//
//
//    @PostMapping("/delay/send")
//    public SendReceipt sendDelayMsg(@RequestBody DelayMsgRequestDto requestDto) throws ClientException {
//        Message message = mqDelayProducerProcessor.buildMsg(StringUtils.toBytes(requestDto.getMsg()), requestDto.getTag(), requestDto.getTopic(), requestDto.getDelayMs(), null);
//        return mqDelayProducerProcessor.sendMsg(delayProducer, message);
//    }
//
//    @PostMapping("/fifo/send")
//    public SendReceipt sendFifoMsg(@RequestBody FifoMsgRequestDto requestDto) throws ClientException {
//        Message message = mqFifoProducerProcessor.buildMsg(StringUtils.toBytes(requestDto.getMsg()), requestDto.getTag(), requestDto.getTopic(), null, requestDto.getMsgGroup());
//        return mqFifoProducerProcessor.sendMsg(fifoProducer, message);
//    }
//
//    @PostMapping("/normal/send")
//    public SendReceipt sendNormalMsg(@RequestBody NormalMsgRequestDto requestDto) throws ClientException {
//        Message message = mqNormalProducerProcessor.buildMsg(StringUtils.toBytes(requestDto.getMsg()), requestDto.getTag(), requestDto.getTopic(), null, null);
//        return mqNormalProducerProcessor.sendMsg(normalProducer, message);
//    }
//
//    @PostMapping("/normal/sendAsync")
//    public SendReceipt sendNormalAsyncMsg(@RequestBody NormalMsgRequestDto requestDto) throws ExecutionException, InterruptedException {
//        Message message = mqNormalProducerProcessor.buildMsg(StringUtils.toBytes(requestDto.getMsg()), requestDto.getTag(), requestDto.getTopic(), null, null);
//        return mqNormalProducerProcessor.sendAsyncMsg(normalProducer, message);
//    }
//
//    @PostMapping("/tx/sendTx")
//    public SendReceipt sendTxMsg(@RequestBody TxMsgRequestDto requestDto) throws ClientException {
//        Message message = mqTxProducerProcessor.buildMsg(StringUtils.toBytes(requestDto.getMsg()), requestDto.getTag(), requestDto.getTopic(), null, null);
//        return mqTxProducerProcessor.sendTxMsg(txProducer, message);
//    }
}
