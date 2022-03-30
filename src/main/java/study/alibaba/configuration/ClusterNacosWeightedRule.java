package study.alibaba.configuration;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tuhao
 * @description
 * @date
 */
@Slf4j
public class ClusterNacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        String clusterName = nacosDiscoveryProperties.getClusterName();
        BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        String name = baseLoadBalancer.getName();
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        try {
            List<Instance> instances = namingService.selectInstances(name, true);
            List<Instance> collect = instances.stream().filter(instance -> instance.equals(clusterName)).collect(Collectors.toList());
            List<Instance> instanceToChoose = new ArrayList<>();
            if(CollectionUtils.isEmpty(collect)){
                instanceToChoose = instances;
                log.warn("发生了跨集群调用,name={},clusterName={},instance={}", name, clusterName, instances);
            }else{
                instanceToChoose = collect;
            }
            Instance hostByRandomWeight2 = ExtendBalance.getHostByRandomWeight2(instanceToChoose);
            log.info("选择的实例时：port = {}, instance = {}", hostByRandomWeight2.getPort(), hostByRandomWeight2);
            return new NacosServer(hostByRandomWeight2);
        } catch (NacosException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class ExtendBalance extends Balancer{
    public static Instance getHostByRandomWeight2(List<Instance> instances){
        return getHostByRandomWeight(instances);
    }
}
