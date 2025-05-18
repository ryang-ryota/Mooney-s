package com.example.mooneys.mapper;

import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.entity.PurchaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseOrderMapper {
    long countByExample(PurchaseOrderExample example);

    int deleteByExample(PurchaseOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrder row);

    int insertSelective(PurchaseOrder row);

    List<PurchaseOrder> selectByExample(PurchaseOrderExample example);

    PurchaseOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") PurchaseOrder row, @Param("example") PurchaseOrderExample example);

    int updateByExample(@Param("row") PurchaseOrder row, @Param("example") PurchaseOrderExample example);

    int updateByPrimaryKeySelective(PurchaseOrder row);

    int updateByPrimaryKey(PurchaseOrder row);

    List<PurchaseOrderWithSupplierDto> selectAllWithSupplier();
}