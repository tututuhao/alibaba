package study.alibaba.feignClient.fallbackFactory;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.alibaba.entity.User;
import study.alibaba.feignClient.PlatformFeignClient;
import study.alibaba.feignClient.PlatformFeignClient2;

/**
 * @author tuhao
 * @description
 * @date
 */
@Component
@Slf4j
public class PlatformFeignClientFallbackFactory implements FallbackFactory<PlatformFeignClient> {
    @Override
    public PlatformFeignClient create(Throwable throwable) {
        return new PlatformFeignClient() {
            @Override
            public User getById(Long id) {
                log.warn("我被限流了");
                User user = User.builder().userName("默认用户")
                        .id(12L).build();
                return user;
            }
        };
    }
}
