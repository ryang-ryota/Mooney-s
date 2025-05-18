package com.example.mooneys.mapper;

import com.example.mooneys.entity.PurchaseItem;
import com.example.mooneys.entity.PurchaseItemExample;
import com.example.mooneys.entity.PurchaseItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseItemMapper {
    long countByExample(PurchaseItemExample example);

    int deleteByExample(PurchaseItemExample example);

    int deleteByPrimaryKey(PurchaseItemKey key);

    int insert(PurchaseItem row);

    int insertSelective(PurchaseItem row);

    List<PurchaseItem> selectByExample(PurchaseItemExample example);

    PurchaseItem selectByPrimaryKey(PurchaseItemKey key);

    int updateByExampleSelective(@Param("row") PurchaseItem row, @Param("example") PurchaseItemExample example);

    int updateByExample(@Param("row") PurchaseItem row, @Param("example") PurchaseItemExample example);

    int updateByPrimaryKeySelective(PurchaseItem row);

    int updateByPrimaryKey(PurchaseItem row);
}