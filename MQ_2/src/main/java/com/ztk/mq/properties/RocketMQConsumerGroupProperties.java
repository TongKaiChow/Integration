package com.ztk.mq.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rocket.consumer-group")
@Data
public class RocketMQConsumerGroupProperties {
    private String concurrent;
    private String fifo;
}
