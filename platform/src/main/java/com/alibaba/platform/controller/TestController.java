package com.alibaba.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.alibaba.platform.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author tuhao
 * @description
 * @date
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Long id){
        log.info("我被调用了-----");
        User user = User.builder()
                .id(12L)
                .userName("tuhao")
                .build();
        return user;
    }

    @GetMapping("/create")
    public User create(User user){
        return user;
    }
}
