package com.example.mooneys.mapper;

import com.example.mooneys.entity.PurchaseOrderItem;
import com.example.mooneys.entity.PurchaseOrderItemExample;
import com.example.mooneys.entity.PurchaseOrderItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseOrderItemMapper {
    long countByExample(PurchaseOrderItemExample example);

    int deleteByExample(PurchaseOrderItemExample example);

    int deleteByPrimaryKey(PurchaseOrderItemKey key);

    int insert(PurchaseOrderItem row);

    int insertSelective(PurchaseOrderItem row);

    List<PurchaseOrderItem> selectByExample(PurchaseOrderItemExample example);

    PurchaseOrderItem selectByPrimaryKey(PurchaseOrderItemKey key);

    int updateByExampleSelective(@Param("row") PurchaseOrderItem row, @Param("example") PurchaseOrderItemExample example);

    int updateByExample(@Param("row") PurchaseOrderItem row, @Param("example") PurchaseOrderItemExample example);

    int updateByPrimaryKeySelective(PurchaseOrderItem row);

    int updateByPrimaryKey(PurchaseOrderItem row);
}