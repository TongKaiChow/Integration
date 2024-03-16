package com.ztk.mq.config;

import com.ztk.mq.properties.RocketMQBrokerProperties;
import com.ztk.mq.properties.RocketMQTopicProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.producer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class RocketMQConfig {
    private final RocketMQBrokerProperties rocketMQBrokerProperties;
    private final RocketMQTopicProperties rocketMQTopicProperties;

//    @Bean
//    public Producer normalProducer() throws ClientException {
//        final ClientServiceProvider provider = ClientServiceProvider.loadService();
//
//        final ProducerBuilder builder = provider.newProducerBuilder()
//                .setClientConfiguration(rocketMQBrokerProperties.getClientConfiguration())
//                .setTopics(rocketMQTopicProperties.getNormal());
//        return builder.build();
//    }
//
//    @Bean
//    public Producer fifoProducer() throws ClientException {
//        final ClientServiceProvider provider = ClientServiceProvider.loadService();
//
//        final ProducerBuilder builder = provider.newProducerBuilder()
//                .setClientConfiguration(rocketMQBrokerProperties.getClientConfiguration())
//                .setTopics(rocketMQTopicProperties.getFifo());
//        return builder.build();
//    }
//
//    @Bean
//    public Producer txProducer() throws ClientException {
//        final ClientServiceProvider provider = ClientServiceProvider.loadService();
//
//        TransactionChecker checker = messageView -> {
//            log.info("Receive transactional message check, message={}", messageView);
//            return TransactionResolution.COMMIT;
//        };
//
//        final ProducerBuilder builder = provider.newProducerBuilder()
//                .setClientConfiguration(rocketMQBrokerProperties.getClientConfiguration())
//                .setTransactionChecker(checker)
//                .setTopics(rocketMQTopicProperties.getTx());
//
//        return builder.build();
//    }
//
//    @Bean
//    public Producer delayProducer() throws ClientException {
//        final ClientServiceProvider provider = ClientServiceProvider.loadService();
//
//        final ProducerBuilder builder = provider.newProducerBuilder()
//                .setClientConfiguration(rocketMQBrokerProperties.getClientConfiguration())
//                .setTopics(rocketMQTopicProperties.getDelay());
//        return builder.build();
//    }

//    @Bean
//    public Producer allTopicProducer() throws ClientException {
//        final ClientServiceProvider provider = ClientServiceProvider.loadService();
//
//        TransactionChecker checker = messageView -> {
//            log.info("Receive transactional message check, message={}", messageView);
//            return TransactionResolution.COMMIT;
//        };
//
//        final ProducerBuilder builder = provider.newProducerBuilder()
//                .setClientConfiguration(rocketMQBrokerProperties.getClientConfiguration())
//                .setTransactionChecker(checker)
//                .setTopics(rocketMQTopicProperties.getAll());
//        return builder.build();
//    }

}
