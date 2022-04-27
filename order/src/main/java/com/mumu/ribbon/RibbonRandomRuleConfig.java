package com.mumu.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mumu
 * @date 2022/4/27
 */
@Configuration
public class RibbonRandomRuleConfig {
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}