package com.project.byw.config;

import org.elasticsearch.common.settings.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@Configuration
@EnableElasticsearchRepositories
public class ElasticSearchConfig {

    @Bean
    public ElasticsearchOperations elasticSearchTemplate() {

        Settings settings = Settings.settingsBuilder()
                .put("path.home", "target/elastic")
                .build();
        return new ElasticsearchTemplate(nodeBuilder().local(true).settings(settings).node().client());
    }
}