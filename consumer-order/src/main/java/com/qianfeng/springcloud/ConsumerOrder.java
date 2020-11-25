package com.qianfeng.springcloud;

import com.qianfeng.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PROVIDER-USER",configuration = TestConfig.class) //启用ribbon,并对PROVIDER-USER进行负载均衡
public class ConsumerOrder {
    @Bean
    @LoadBalanced //使用Ribbon的时候，必须要在RestTemplate bean配置中添加负载均衡注解
    public RestTemplate getTemp() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder.class);
    }
}

