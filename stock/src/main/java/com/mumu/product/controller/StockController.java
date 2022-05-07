package com.mumu.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumu
 * @date 2022/4/21
 */

@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    String port;

    @GetMapping("/reduct")
    public String reduct() {
        //Thread.sleep(5000);
        // 制造异常触发降级
        //int i = 2 / 0;
        System.out.println(port + " 扣减库存");
        return port + " 扣减库存";
    }
}