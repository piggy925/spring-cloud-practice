package com.mumu.gateway.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author mumu
 * @date 2022/05/07
 */

@Component
public class CheckNameRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckNameRoutePredicateFactory.Config> {
    public CheckNameRoutePredicateFactory() {
        super(CheckNameRoutePredicateFactory.Config.class);
    }

    // 结合 shortcutFieldOrder 进行属性绑定
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    // 重写 apply 方法进行逻辑判断
    @Override
    public Predicate<ServerWebExchange> apply(CheckNameRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            public boolean test(ServerWebExchange exchange) {
                if (config.getName().equals("mumu")) {
                    return true;
                }
                return false;
            }
        };
    }

    // 创建静态内部类，在其内部声明属性来接收配置文件中对应的断言信息
    @Validated
    public static class Config {
        private String name;
        
        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}