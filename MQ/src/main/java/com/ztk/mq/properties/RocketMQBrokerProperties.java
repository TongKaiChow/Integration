package com.ztk.mq.properties;

import com.ztk.mq.override.RocketMQBrokerInstance;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.StaticSessionCredentialsProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConfigurationProperties(prefix = "rocket.instance")
@Data
public class RocketMQBrokerProperties {
    private String accessKey;
    private String accessSecret;
    private String endPoint;

    public ClientConfiguration getClientConfiguration() {
        StaticSessionCredentialsProvider staticSessionCredentialsProvider = new StaticSessionCredentialsProvider(this.accessKey, this.accessSecret);
        ClientConfiguration mqBrokerClient = ClientConfiguration.newBuilder().setEndpoints(this.endPoint).setCredentialProvider(staticSessionCredentialsProvider).build();
        return mqBrokerClient;
    }
}
