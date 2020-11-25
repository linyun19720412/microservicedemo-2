package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class OrderController {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.url}")
    private String url;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //    private String url="http://localhost:7900/user/";
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id) {
//        InstanceInfo instanceInfo =eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
//        String homePageUrl= instanceInfo.getHomePageUrl();
        User user = restTemplate.getForObject("http://PROVIDER-USER/user/" + id, User.class);//通过访问rest获取到json数据，然后转换为user对象

        return user;
    }
    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance1 =loadBalancerClient.choose("PROVIDER-USER");//查找对应服务的实例，会通过负载均衡算法返回一个
        System.err.println("1111"+serviceInstance1.getServiceId()+serviceInstance1.getHost()+":"+serviceInstance1.getPort());
        return "1";

    }

}
