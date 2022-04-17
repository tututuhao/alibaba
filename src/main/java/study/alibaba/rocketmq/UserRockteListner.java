package study.alibaba.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import study.alibaba.entity.User;

/**
 * @author tuhao
 * @description
 * @date
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "test-consumer", topic = "test-user")
public class UserRockteListner implements RocketMQListener<User> {
    @Override
    public void onMessage(User user) {
        log.info("从rockterMq获取的消息::{}", user);
    }
}
