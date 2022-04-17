package com.alibaba.gateway;

import com.alibaba.gateway.auth.CheckLogin;
import com.alibaba.gateway.util.JwtOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author tuhao
 * @description
 * @date
 */
@RestController
public class TestController {

    @Autowired
    private JwtOperator jwtOperator;

    @GetMapping("login")
    public String login(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "hao");
        map.put("password", "123456");
        String generateToken = jwtOperator.generateToken(map);
        return generateToken;
    }

    @GetMapping("getMoney")
    @CheckLogin
    public String getMoiney(){
        return "赏黄金万两";
    }
}
