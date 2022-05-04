package com.mumu.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mumu
 * @date 2022/05/04
 */
@MapperScan(basePackages = "com.mumu.stock.mapper")
@SpringBootApplication
public class StockSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockSeataApplication.class, args);
    }
}