package com.example.mooneys.repository;

import com.example.mooneys.entity.PurchaseOrderItem;

import java.util.List;

/**
 * 仕入発注明細情報に関するデータアクセスを行うリポジトリインターフェース
 */
public interface PurchaseOrderItemRepository {

    /**
     * すべての仕入発注明細情報を取得する
     *
     * @return 仕入発注明細情報のリスト
     */
    List<PurchaseOrderItem> findAll();

    /**
     * 指定された仕入発注IDに紐づく発注明細情報を取得する
     *
     * @param purchaseOrderId 仕入発注ID
     * @return 該当する仕入発注明細情報のリスト
     */
    List<PurchaseOrderItem> findByPurchaseOrderId(Integer purchaseOrderId);

    /**
     * 新規仕入発注明細情報を登録する
     *
     * @param entity 登録する仕入発注明細情報
     */
    void insert(PurchaseOrderItem entity);

    /**
     * 既存の仕入発注明細情報を更新する
     *
     * @param entity 更新する仕入発注明細情報
     */
    void update(PurchaseOrderItem entity);

    /**
     * 指定された仕入発注IDに紐づく仕入発注明細情報を削除する
     *
     * @param purchaseOrderId 削除対象の仕入発注ID
     */
    void deleteByPurchaseOrderId(Integer purchaseOrderId);
}