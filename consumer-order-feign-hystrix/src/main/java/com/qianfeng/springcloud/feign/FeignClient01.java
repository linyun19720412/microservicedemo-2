package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create from zly 2020/11/27
 **/
@Primary
@FeignClient(name="PROVIDER-USER",fallback = FeignClientHyStrix.class)
public interface FeignClient01 {
    @RequestMapping("/user/{id}") //组合注解，第一个是请求方式，第二个是参数，用空格分割
    User getOrder(@PathVariable("id") Long id); //使用RequestLine时候必须使用此注解

    @RequestMapping("/get-user")
    User get_user(User user); //如果你传递的是复杂参数，那么feign不管你配置的是什么请求方式，都会以post方式发出去

}
