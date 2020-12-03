package com.qianfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * create from zly 2020/12/3
 **/
@SpringBootApplication
@EnableZuulProxy //启用Zuul，自带熔断和自动注册到eureka
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);

    }
}
