package com.ztk.es.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * es客户端配置类, @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
 */
@Configuration
public class EsClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean(name = {"restHighLevelClient"})
    public RestHighLevelClient elasticsearchClient() {
        return null;
    }
}
