package com.mumu.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author mumu
 * @date 2022/4/27
 */
public class CustomRule extends AbstractLoadBalancerRule {
    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();

        // 获得当前请求的服务的实例
        List<Server> servers = loadBalancer.getReachableServers();
        // 随机选择一个 server
        int random = ThreadLocalRandom.current().nextInt(servers.size());
        Server server = servers.get(random);
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}