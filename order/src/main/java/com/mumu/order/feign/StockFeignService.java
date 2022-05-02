package com.mumu.order.feign;

import com.mumu.order.feign.fallback.StockFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mumu
 * @date 2022/4/28
 */
// name: 指定被调用的接口所在的服务名
// path：被调用的接口所在的 Controller 指定的 @RequestMapping 地址
@FeignClient(name = "stock-service", path = "/stock", fallback = StockFeignServiceFallback.class)
public interface StockFeignService {
    // 声明被调用的接口中对应的方法
    @GetMapping("/reduct")
    String reduct();
}