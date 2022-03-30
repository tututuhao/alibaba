package study.alibaba.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.alibaba.entity.User;

/**
 * @author tuhao
 * @description platform远程调用
 * @date
 */
@Component
//@FeignClient(name = "platform", configuration = PlatformFeignConfigration.class)
@FeignClient(name = "platform")
public interface PlatformFeignClient2 {

    @GetMapping(value = "/create")
    User create(@SpringQueryMap  User user);
}
