package com.mumu.order.feign.fallback;

import com.mumu.order.feign.StockFeignService;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @date 2022/05/02
 */
@Component
public class StockFeignServiceFallback implements StockFeignService {
    @Override
    public String reduct() {
        return "接口访问被降级了";
    }
}