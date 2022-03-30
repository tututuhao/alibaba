package study.alibaba.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;

/**
 * @author tuhao
 * @description
 * @date
 */
@Configuration
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class AlibabaRibbonConfiguration {


}
