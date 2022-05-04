package com.mumu.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mumu
 * @date 2022/05/04
 */
@FeignClient(value = "stock-seata", path = "/stock")
public interface StockService {
    @GetMapping("/reduct")
    String reduct(@RequestParam(value = "productId") Integer productId);
}