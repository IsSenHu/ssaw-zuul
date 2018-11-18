package com.ssaw.ssawzuul;

import com.netflix.zuul.FilterProcessor;
import com.ssaw.ssawzuul.processor.SsawFilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author HS
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);

        //****************启用自定义核心处理器*******************
        FilterProcessor.setProcessor(new SsawFilterProcessor());
    }
}
