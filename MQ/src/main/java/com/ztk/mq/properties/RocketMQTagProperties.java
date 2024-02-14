package com.ztk.mq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rocket.tag")
@Data
public class RocketMQTagProperties {
    private String tag1;
    private String tag2;
    private String tag3;
}
