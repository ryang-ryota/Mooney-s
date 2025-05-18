package com.example.mooneys.form;

import com.example.mooneys.dto.PurchaseOrderItemWithTitleDto;
import com.example.mooneys.entity.PurchaseOrderItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 仕入発注フォームクラス
 * 仕入発注の入力および編集に使用する情報を保持するフォームクラス
 */
@Getter
@Setter
public class PurchaseOrderForm {

    /**
     * 仕入発注ID
     */
    private Integer id;

    /**
     * 仕入先ID
     * 仕入先を一意に特定するためのID
     */
    private Integer supplierId;

    /**
     * 仕入先名
     * 画面表示用の仕入先名称
     */
    private String supplierName;

    /**
     * 発注日
     * 仕入発注を行った日付
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    /**
     * 仕入発注明細リスト
     * 発注する書籍の情報（ISBNコード、数量、仕入単価など）を保持するリスト
     */
    private List<PurchaseOrderItemWithTitleDto> purchaseOrderItems;

    /**
     * ステータス
     * 仕入発注の状態を表す（例：発注済、納品済）
     */
    private String status;

}