package com.lab3better.order.database;

import com.lab3better.order.model.Product;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

import java.math.BigDecimal;

@Configuration
public class SeedData {
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
          log.info("Adding " + repository.save(new Product("Smoczek", new BigDecimal("10.20"))));
        };
    }
}
