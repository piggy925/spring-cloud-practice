package com.mumu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

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
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);
        while (true) {
            String name = applicationContext.getEnvironment().getProperty("user.name");
            String age = applicationContext.getEnvironment().getProperty("user.age");
            String sex = applicationContext.getEnvironment().getProperty("config.sex");
            System.out.println("name: " + name);
            System.out.println("age: " + age);
            TimeUnit.SECONDS.sleep(1);
            
        }
    }
}