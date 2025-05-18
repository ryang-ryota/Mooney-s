package com.example.mooneys.dto;

import com.example.mooneys.entity.PurchaseOrderItem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * 仕入発注DTOクラス
 * 仕入発注情報と仕入発注明細情報を保持する
 */
@Getter
@Setter
public class PurchaseOrderDto {

    /**
     * 仕入発注ID
     */
    private Integer id;

    /**
     * 仕入先ID
     */
    private Integer supplierId;

    /**
     * 仕入先名
     */
    private String supplierName;

    /**
     * 発注日
     */
    private LocalDate orderDate;

    /**
     * ステータス
     */
    private String status;

    /**
     * 仕入発注明細リスト
     */
    private List<PurchaseOrderItemWithTitleDto> purchaseOrderItems;

}