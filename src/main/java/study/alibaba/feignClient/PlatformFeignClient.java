package study.alibaba.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.alibaba.configuration.PlatformFeignConfigration;
import study.alibaba.entity.User;
import study.alibaba.feignClient.fallbackFactory.PlatformFeignClientFallbackFactory;

/**
 * @author tuhao
 * @description platform远程调用
 * @date
 */
@Component
//@FeignClient(name = "platform", configuration = PlatformFeignConfigration.class)
@FeignClient(name = "platform", fallbackFactory = PlatformFeignClientFallbackFactory.class
)
public interface PlatformFeignClient {

    @GetMapping(value = "/{id}")
    User getById(@PathVariable(value = "id") Long id);
}
