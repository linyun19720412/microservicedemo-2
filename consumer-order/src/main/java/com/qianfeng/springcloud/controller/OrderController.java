package com.qianfeng.springcloud.controller;

import com.qianfeng.springcloud.feign.FeignClient01;
import com.qianfeng.springcloud.feign.FeignClient02;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class OrderController {
    @Autowired
    private FeignClient01 feignClient01;
    @Autowired
    private FeignClient02 feignClient02;
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable("id") Long id) {
        User order = feignClient01.getOrder(id);
        return order;
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
