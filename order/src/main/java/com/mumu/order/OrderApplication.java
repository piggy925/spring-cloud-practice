package com.mumu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mumu
 * @date 2022/4/21
 */
//@RibbonClients(value = {
//        @RibbonClient(name = "stock-service", configuration = RibbonRandomRuleConfig.class)
//})
@EnableFeignClients
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}