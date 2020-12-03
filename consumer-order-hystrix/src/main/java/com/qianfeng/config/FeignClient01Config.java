package com.qianfeng.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create from zly 2020/11/30
 **/
@Configuration
public class FeignClient01Config {
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }

}
