package com.mumu.stock.service.impl;

import com.mumu.stock.mapper.StockMapper;
import com.mumu.stock.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mumu
 * @date 2022/05/04
 */
@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper stockMapper;

    @Override
    public void reduct(Integer productId) {
        System.out.println("更新商品:" + productId);
        stockMapper.reduct(productId);
    }
}