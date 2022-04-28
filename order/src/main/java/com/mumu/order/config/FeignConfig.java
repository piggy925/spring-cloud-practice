package com.mumu.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author mumu
 * @date 2022/4/28
 */
// 全局配置：使用 @Configuration 注解会将配置作用在所有的服务提供方
// 局部配置：若仅针对某一个服务进行配置，不要加 @Configuration 注解
//@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 契约配置
     */
    //@Bean
    //public Contract feignContract() {
    //    return new Contract.Default();
    //}

    /**
     * 超时时间配置
     */
    //@Bean
    //public Request.Options options() {
    //    return new Request.Options(5L, TimeUnit.MILLISECONDS, 10L, TimeUnit.MILLISECONDS, false);
    //}

    /**
     * 配置拦截器
     */
    //@Bean
    //public CustomFeignInterceptor customFeignInterceptor() {
    //    return new CustomFeignInterceptor();
    //}
}