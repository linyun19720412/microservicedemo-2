package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import org.springframework.stereotype.Component;
import java.util.Date;
/**
 * create from zly 2020/11/30
 **/
@Component
public class FeignClientHyStrix implements FeignClient01 {

    @Override
    public User getOrder(Long id) {
        User user=new User();
        user.setId(-300L);
        user.setDate(new Date());
        return user;
    }

    @Override
    public User get_user(User user) {
        return user;
    }
}
