package com.ztk.client.feignclient.hystrixclient;

import com.ztk.client.feignclient.MqFeignClient;
import com.ztk.mq_common.vo.DelayMsgRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.stereotype.Component;

/**
 * FeignClient后备类
 */
@Component
@Slf4j
public class MqFeignClientFallback implements MqFeignClient {
    /**
     * 远程服务的方法体
     *
     * @param requestDto
     */
    @Override
    public SendReceipt sendDelayMsg(DelayMsgRequestDto requestDto) {
        log.warn("MqFeignClient fallback warning by client");
        return () -> null;
    }
}
