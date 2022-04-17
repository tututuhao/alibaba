//package com.alibaba.gateway;
//
//import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.time.LocalTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Predicate;
//
///**
// * @author tuhao
// * @description
// * @date
// */
//@Component
//public class TimeHaoRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeCofig> {
//
//    public TimeHaoRoutePredicateFactory() {
//        super(TimeCofig.class);
//    }
//
//    @Override
//    public Predicate<ServerWebExchange> apply(TimeCofig config) {
//        LocalTime start = config.getStart();
//        LocalTime end = config.getEnd();
//        return exchange -> {
//            LocalTime now = LocalTime.now();
//            return now.isAfter(start) && now.isBefore(end);
//        };
//    }
//
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("start", "end");
//    }
//}
