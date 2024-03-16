package com.ztk.mq.override;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.StaticSessionCredentialsProvider;

@Slf4j
public class RocketMQBrokerInstance extends StaticSessionCredentialsProvider {

    public RocketMQBrokerInstance(String accessKey, String accessSecret) {
        super(accessKey, accessSecret);
    }

    public RocketMQBrokerInstance(String accessKey, String accessSecret, String securityToken) {
        super(accessKey, accessSecret, securityToken);
    }
}
