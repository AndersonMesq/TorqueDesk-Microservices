package com.andersonmesq.service_order_service.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {
    @Bean
    PageableHandlerMethodArgumentResolverCustomizer pageableCustom(){
        return pageableResolver -> pageableResolver.setMaxPageSize(100);
    }
}
