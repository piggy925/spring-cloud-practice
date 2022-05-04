package com.mumu.order.service.impl;

import com.mumu.order.api.StockService;
import com.mumu.order.mapper.OrderMapper;
import com.mumu.order.pojo.Order;
import com.mumu.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mumu
 * @date 2022/05/04
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    StockService stockService;

    /**
     * 下单
     */
    @GlobalTransactional
    @Override
    public Order create(Order order) {
        // 插入订单
        orderMapper.insert(order);

        // 远程调用扣减库存服务
        stockService.reduct(order.getProductId());

        // 触发异常
        int a = 1 / 0;

        return order;
    }
}