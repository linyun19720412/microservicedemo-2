package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * create from zly 2020/12/1
 **/
@Component
public class FeignClient01Factory implements FallbackFactory<FeignClient01>{
    @Override
    public FeignClient01 create(Throwable throwable) {
        return new FeignClient01() {
            @Override
            public User getOrder(Long id) {
                User user=new User();
                user.setId(-500L);
                user.setDate(new Date());
                return user;
            }

            @Override
            public User get_user(User user) {
                return user;
            }
        };
    }
}
