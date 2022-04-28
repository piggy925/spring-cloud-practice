package com.mumu.order.feign;

import com.mumu.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mumu
 * @date 2022/4/28
 */
@FeignClient(name = "product-service", path = "/product", configuration = FeignConfig.class)
public interface ProductFeignService {
    @GetMapping("/{id}")
    String get(@PathVariable("id") Integer id);
}