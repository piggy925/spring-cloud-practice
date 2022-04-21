package com.mumu.stock.controller;

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
    @GetMapping("/reduct")
    public String reduct() {
        System.out.println("扣减库存");
        return "扣减库存";
    }
}