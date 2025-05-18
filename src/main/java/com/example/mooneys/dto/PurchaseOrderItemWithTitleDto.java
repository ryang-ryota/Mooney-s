package com.example.mooneys.dto;

import com.example.mooneys.entity.PurchaseOrderItem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * 仕入発注明細DTOクラス
 * 仕入発注明細情報と書籍タイトルを保持する
 */
@Getter
@Setter
public class PurchaseOrderItemWithTitleDto extends PurchaseOrderItem {

    /**
     * 書籍タイトル
     */
    private String title;

}