package com.qianfeng.springcloud.feign;

import com.qianfeng.config.FeignClient02Config;
import com.qianfeng.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create from zly 2020/11/27
 **/
@FeignClient(name="fdasd",url="http://localhost:20000/",configuration = FeignClient02Config.class)
public interface FeignClient02 {
    @RequestMapping("/eureka/apps/{servicename}")
    String getServiceInfo(@PathVariable("servicename") String servicename);

}
