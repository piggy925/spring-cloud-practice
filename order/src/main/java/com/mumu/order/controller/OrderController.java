package com.mumu.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mumu.order.feign.ProductFeignService;
import com.mumu.order.feign.StockFeignService;
import com.mumu.order.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    IOrderService orderService;
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
        return "HELLO FEIGN - " + "Stock 接口：" + s + "   Product 接口：" + p;
    }

    /**
     * 注解指定的流控处理方法
     */
    public String addBlockHandler(BlockException e) {
        return "请求已被流控";
    }

    // 链路流控
    @GetMapping("/getUser1")
    public String test1() {
        return orderService.getUser();
    }

    // 链路流控
    @GetMapping("/getUser2")
    public String test2() {
        return orderService.getUser();
    }

    /**
     * 热点参数流控，必须使用@SentinelResource
     */
    @RequestMapping("/get/{id}")
    @SentinelResource(value = "getById", blockHandler = "HotBlockHandler")
    public String getById(@PathVariable("id") Integer id) throws InterruptedException {
        System.out.println("正常访问");
        return "正常访问";
    }

    public String HotBlockHandler(@PathVariable("id") Integer id, BlockException e) throws InterruptedException {
        return "热点异常处理";
    }
}