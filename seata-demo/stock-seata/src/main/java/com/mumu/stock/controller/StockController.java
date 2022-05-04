package com.mumu.stock.controller;

import com.mumu.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mumu
 * @date 2022/05/04
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Resource
    StockService stockService;

    @GetMapping("/reduct")
    public String reduct(@RequestParam(value = "productId") Integer productId) {
        stockService.reduct(productId);
        return "扣减库存";
    }
}