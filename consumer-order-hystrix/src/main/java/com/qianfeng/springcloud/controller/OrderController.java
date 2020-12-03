package com.qianfeng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qianfeng.springcloud.feign.FeignClient01;
import com.qianfeng.springcloud.feign.FeignClient02;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController

public class OrderController {
    @Autowired
    private FeignClient01 feignClient01;
    @Autowired
    private FeignClient02 feignClient02;
    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "shibai",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE")
    }
        )
    public User getOrder(@PathVariable("id") Long id) {
        User order = feignClient01.getOrder(id);
        return order;
    }
    public User shibai(Long id){
        User user=new User();
        user.setId(-100L);
        user.setDate(new Date());
        return user;

    }



    @GetMapping("/get-user")
    public User getUser(User user){
        User order=feignClient01.get_user(user);
        return order;
    }

    @RequestMapping("serviceinfo/{name}")
    public String getServiceInfo(@PathVariable String name){
        return feignClient02.getServiceInfo(name);

    }

}
