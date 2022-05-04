package com.mumu.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mumu
 * @date 2022/05/04
 */
@Mapper
public interface StockMapper extends BaseMapper<StockMapper> {
    void reduct(Integer productId);
}