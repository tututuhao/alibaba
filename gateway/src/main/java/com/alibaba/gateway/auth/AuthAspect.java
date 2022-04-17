package com.alibaba.gateway.auth;

import com.alibaba.gateway.util.JwtOperator;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tuhao
 * @description
 * @date
 */
@Aspect
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class AuthAspect {
    private final JwtOperator jwtOperator;

    @Around("@annotation(com.alibaba.gateway.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        checkLogin();
        return point.proceed();
    }

    private void checkLogin(){
        //1.从header里面获取token
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        String token = httpServletRequest.getHeader("x-token");

        if(!jwtOperator.validateToken(token)){
            throw new SecurityException("token不合法");
        }

        //3.校验成功，将用户的信息放入到request里
        Claims claims = jwtOperator.getClaimsFromToken(token);
        httpServletRequest.setAttribute("id", claims.get("id"));
        httpServletRequest.setAttribute("name", claims.get("name"));
        httpServletRequest.setAttribute("password", claims.get("password"));
    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }
}
