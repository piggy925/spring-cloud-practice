package com.mumu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author mumu
 * @date 2022/05/04
 */
@EnableFeignClients
@MapperScan(basePackages = "com.mumu.order.mapper")
@SpringBootApplication
// 开启本地事务@Transactional
@EnableTransactionManagement
public class OrderSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSeataApplication.class, args);
    }

}