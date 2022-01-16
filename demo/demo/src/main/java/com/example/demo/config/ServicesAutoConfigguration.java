package com.example.demo.config;

import com.example.demo.service.CustomerService;
import com.example.demo.service.DefaultCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesAutoConfigguration {

    @Bean
    public CustomerService customerService() {
        return new DefaultCustomerService();
    }
}
