package com.qianfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主程序
 */
@RestController
@SpringBootApplication
@EnableEurekaClient
public class ProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser.class);
    }
}
