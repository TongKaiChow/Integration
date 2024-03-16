package com.ztk.client.controller;

import com.ztk.client.feignclient.MqFeignClient;
import com.ztk.mq_common.vo.DelayMsgRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    /**
     * 注入feignClient，调用其中的方法来rpc(http形式-ribbon实现)
     */
    private final MqFeignClient mqFeignClient;

    @PostMapping("/delay/send")
    public SendReceipt sendDelayMsg(@RequestBody DelayMsgRequestDto requestDto) throws ClientException {
        return mqFeignClient.sendDelayMsg(requestDto);
    }
}
