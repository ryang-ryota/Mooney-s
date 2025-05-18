package com.example.mooneys.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

/**
 * 仕入先名を含む仕入発注DTOクラス
 * 仕入発注と仕入先名を保持する
 */
@Getter
@Setter
public class PurchaseOrderWithSupplierDto {

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
}