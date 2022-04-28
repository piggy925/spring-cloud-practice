package com.mumu.order.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mumu
 * @date 2022/4/28
 */
public class CustomFeignInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CustomFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("Feign 拦截器");
    }
}