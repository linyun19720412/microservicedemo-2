package com.qianfeng.springcloud.feign;

import com.qianfeng.config.FeignClient01Config;
import com.qianfeng.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * create from zly 2020/11/27
 **/
@FeignClient(name="PROVIDER-USER",configuration = FeignClient01Config.class)
public interface FeignClient01 {
    @RequestLine("GET /user/{id}") //组合注解，第一个是请求方式，第二个是参数，用空格分割
    User getOrder(@Param("id") Long id); //使用RequestLine时候必须使用此注解

    @RequestLine("GET /get-user")
    User get_user(User user); //如果你传递的是复杂参数，那么feign不管你配置的是什么请求方式，都会以post方式发出去

}
