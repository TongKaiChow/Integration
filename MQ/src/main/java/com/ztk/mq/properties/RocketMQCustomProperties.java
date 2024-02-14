package com.ztk.mq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rocket.custom")
@Data
public class RocketMQCustomProperties {
    private long delayMillSecond;
    private String delayTopic;
    private String delayTag;
    private String delayKeys;

    private String normalTopic;
    private String normalTag;
    private String normalKeys;

    private String fifoTopic;
    private String fifoTag;
    private String fifoKeys;
    private String fifoMessageGroup;
}
