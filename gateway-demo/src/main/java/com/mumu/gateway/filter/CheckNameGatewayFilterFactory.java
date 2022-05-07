package com.mumu.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author mumu
 * @date 2022/05/07
 */
@Component
public class CheckNameGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckNameGatewayFilterFactory.Config> {
    public CheckNameGatewayFilterFactory() {
        super(CheckNameGatewayFilterFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("value");
    }

    @Override
    public GatewayFilter apply(CheckNameGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 获取 name 参数
                String name = exchange.getRequest().getQueryParams().getFirst("name");
                if (StringUtils.isNotBlank(name)) {
                    // 符合条件则执行过滤
                    if (config.getValue().equals(name)) {
                        return chain.filter(exchange);
                    } else {
                        // 不符合条件则返回 404
                        exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                        return exchange.getResponse().setComplete();
                    }
                }
                return chain.filter(exchange);
            }
        };
    }

    public static class Config {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}