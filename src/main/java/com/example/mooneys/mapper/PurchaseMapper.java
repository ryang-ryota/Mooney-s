package com.example.mooneys.mapper;

import com.example.mooneys.entity.Purchase;
import com.example.mooneys.entity.PurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseMapper {
    long countByExample(PurchaseExample example);

    int deleteByExample(PurchaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Purchase row);

    int insertSelective(Purchase row);

    List<Purchase> selectByExample(PurchaseExample example);

    Purchase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Purchase row, @Param("example") PurchaseExample example);

    int updateByExample(@Param("row") Purchase row, @Param("example") PurchaseExample example);

    int updateByPrimaryKeySelective(Purchase row);

    int updateByPrimaryKey(Purchase row);
}