package com.example.mooneys.mapper;

import com.example.mooneys.entity.FlywaySchemaHistory;
import com.example.mooneys.entity.FlywaySchemaHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FlywaySchemaHistoryMapper {
    long countByExample(FlywaySchemaHistoryExample example);

    int deleteByExample(FlywaySchemaHistoryExample example);

    int deleteByPrimaryKey(Integer installedRank);

    int insert(FlywaySchemaHistory row);

    int insertSelective(FlywaySchemaHistory row);

    List<FlywaySchemaHistory> selectByExample(FlywaySchemaHistoryExample example);

    FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

    int updateByExampleSelective(@Param("row") FlywaySchemaHistory row, @Param("example") FlywaySchemaHistoryExample example);

    int updateByExample(@Param("row") FlywaySchemaHistory row, @Param("example") FlywaySchemaHistoryExample example);

    int updateByPrimaryKeySelective(FlywaySchemaHistory row);

    int updateByPrimaryKey(FlywaySchemaHistory row);
}