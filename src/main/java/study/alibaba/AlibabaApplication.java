package study.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import study.alibaba.configuration.PlatformFeignConfigration;

@SpringBootApplication
@EnableFeignClients//(defaultConfiguration = PlatformFeignConfigration.class)
@MapperScan({"study.alibaba.douyin.mapper"})
public class AlibabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
