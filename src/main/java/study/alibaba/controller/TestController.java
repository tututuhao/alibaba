package study.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.JSONUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.alibaba.douyin.mapper.VideosMapper;
import study.alibaba.entity.User;
import study.alibaba.feignClient.PlatformFeignClient;
import study.alibaba.feignClient.PlatformFeignClient2;
import study.alibaba.feignClient.PlatformFeignClient3;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tuhao
 * @description
 * @date
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private PlatformFeignClient feignClient;

    @Autowired
    private PlatformFeignClient2 feignClient2;

    @Autowired
    private PlatformFeignClient3 feignClient3;

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

//    @GetMapping("/{id}")
//    public List<Videos>  getUserInfo(@PathVariable Long id){
//        List<study.alibaba.douyin.entity.Videos> videos = videosMapper.selectList(null);
//        Videos videos1 = new Videos();
//        videos1.setId("180510CCNC7C9FCH");
//        videosMapper.selectOne(videos1);
//        return videos;
 //   }

    @GetMapping("/create")
    public User create(User user){
        return feignClient2.create(user);
    }

    @GetMapping("/3/{id}")
    @SentinelResource
    public User getUserInfo2(@PathVariable Long id){
        User user = User.builder()
                .id(12L)
                .userName("test").build();
        rocketMQTemplate.convertAndSend("test-user", user);
        return user;
    }
}
