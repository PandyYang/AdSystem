package com.pandy.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 9:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
public class SponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class,args);
    }
}
