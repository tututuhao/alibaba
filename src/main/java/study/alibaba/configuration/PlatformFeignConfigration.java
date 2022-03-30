package study.alibaba.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author tuhao
 * @description
 * @date
 */
public class PlatformFeignConfigration {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
