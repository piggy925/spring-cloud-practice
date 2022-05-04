package com.mumu.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mumu.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mumu
 * @date 2022/05/04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    int insert(Order order);
}