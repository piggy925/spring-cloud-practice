package com.mumu.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumu
 * @date 2022/4/21
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    String port;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id) {
        String msg = "端口：+" + port + " 查询商品：" + id;
        System.out.println(msg);
        return msg;
    }
}