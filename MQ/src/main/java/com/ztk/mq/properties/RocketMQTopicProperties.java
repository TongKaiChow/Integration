package com.ztk.mq.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rocket.topic")
@Data
public class RocketMQTopicProperties {
    private String tx;
    private String normal;
    private String fifo;
    private String delay;
    private String all;
}
