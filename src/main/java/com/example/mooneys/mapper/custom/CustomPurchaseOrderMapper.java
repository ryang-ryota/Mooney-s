package com.example.mooneys.mapper.custom;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 仕入発注に関するカスタムSQLマッパーインターフェース
 */
@Mapper
public interface CustomPurchaseOrderMapper {

    /**
     * 仕入発注一覧を仕入先情報を含めて取得する
     *
     * @return 仕入先情報を含む仕入発注DTOのリスト
     */
    List<PurchaseOrderWithSupplierDto> selectAllWithSupplier();

    /**
     * 指定されたIDの仕入発注を仕入先情報を含めて取得する
     *
     * @param id 仕入発注ID
     * @return 仕入先情報を含む仕入発注DTO
     */
    PurchaseOrderWithSupplierDto selectByIdWithSupplier(@Param("id") Integer id);

    /**
     * 指定されたIDの仕入発注詳細(発注明細を含む)を取得する
     *
     * @param id 仕入発注ID
     * @return 仕入発注明細を含む仕入発注DTO
     */
    PurchaseOrderDto findOrderDetail(@Param("id") Integer id);
}