package com.gmail.arthurstrokov.feignclient.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 27.10.2022
 */
@Configuration
public class GlobalConfig {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
