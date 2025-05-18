package com.example.mooneys.mapper;

import com.example.mooneys.entity.Stock;
import com.example.mooneys.entity.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stock row);

    int insertSelective(Stock row);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Stock row, @Param("example") StockExample example);

    int updateByExample(@Param("row") Stock row, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock row);

    int updateByPrimaryKey(Stock row);
}