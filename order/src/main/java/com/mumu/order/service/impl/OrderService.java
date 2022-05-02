package com.mumu.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mumu.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @author mumu
 * @date 2022/05/02
 */
@Service
public class OrderService implements IOrderService {
    @SentinelResource(value = "user", blockHandler = "blockHandlerGetUser")
    @Override
    public String getUser() {
        return "查询用户";
    }

    public String blockHandlerGetUser(BlockException e) {
        return "流控查询用户";
    }
}