package com.alibaba.gateway;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

/**
 * @author tuhao
 * @description
 * @date
 */
@Data
public class TimeCofig {

    /**
     * 开始时间
     */
    private LocalTime start;

    /**
     * 结束时间
     */
    private LocalTime end;
}
