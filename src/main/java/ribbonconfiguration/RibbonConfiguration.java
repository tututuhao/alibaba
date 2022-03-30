package ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import study.alibaba.configuration.ClusterNacosWeightedRule;
import study.alibaba.configuration.NacosWeightedRule;

/**
 * @author tuhao
 * @description ribbon配置
 * @date
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new ClusterNacosWeightedRule();
    }
}
