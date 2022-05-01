package com.mumu.order.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mumu.order.feign.ProductFeignService;
import com.mumu.order.feign.StockFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mumu
 * @date 2022/4/21
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private StockFeignService stockFeignService;
    @Resource
    private ProductFeignService productFeignService;

    @GetMapping("/add")
    //@SentinelResource(value = "add", blockHandler = "addBlockHandler")
    public String add() {
        System.out.println("下单成功");
        String s = stockFeignService.reduct();
        String p = productFeignService.get(999);
        return "HELLO FEIGN - " + s + p;
    }

    /**
     * 注解指定的流控处理方法
     */
    public String addBlockHandler(BlockException e) {
        return "请求已被流控";
    }
}