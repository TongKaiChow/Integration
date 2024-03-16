package com.ztk.client.feignclient.hystrixclient;

import com.ztk.client.feignclient.MqFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.stereotype.Component;

/**
 * FeignClient后备工厂类
 */
@Component
@Slf4j
public class MqFeignClientFallbackFactory implements FallbackFactory<MqFeignClient> {
    @Override
    public MqFeignClient create(Throwable throwable) {
        return requestDto -> {
            log.warn("MqFeignClient fallback warning by factory");
            return (SendReceipt) () -> null;
        };
    }
}
