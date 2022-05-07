package com.mumu.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author mumu
 * @date 2022/05/07
 */
@Component
public class LogFilter implements GlobalFilter {
    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOG.info("==========> 请求路径：" + exchange.getRequest().getPath().value());
        return chain.filter(exchange);
    }
}