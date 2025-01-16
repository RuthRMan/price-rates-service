package com.services.product.pricerates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.services.product.pricerates.application.services.PriceRatesProductService;
import com.services.product.pricerates.infraestructure.adapter.mapper.ProductMapper;

@Configuration
public class PriceRateServiceConfig {

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    public PriceRatesProductService priceRatesProductService() {
        return new PriceRatesProductService();
    }
    
}
