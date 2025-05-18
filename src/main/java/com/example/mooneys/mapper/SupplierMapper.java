package com.example.mooneys.mapper;

import com.example.mooneys.entity.Supplier;
import com.example.mooneys.entity.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupplierMapper {
    long countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Supplier row);

    int insertSelective(Supplier row);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Supplier row, @Param("example") SupplierExample example);

    int updateByExample(@Param("row") Supplier row, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier row);

    int updateByPrimaryKey(Supplier row);
}