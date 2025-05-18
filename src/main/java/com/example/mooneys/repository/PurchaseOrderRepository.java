package com.example.mooneys.repository;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;

import java.util.List;

/**
 * 仕入発注に関するデータアクセスを行うリポジトリインターフェース
 */
public interface PurchaseOrderRepository {

    /**
     * すべての仕入発注情報を取得する
     *
     * @return 仕入発注情報のリスト
     */
    List<PurchaseOrder> findAll();

    /**
     * 指定されたIDの仕入発注情報を取得する
     *
     * @param id 仕入発注ID
     * @return 該当する仕入発注情報、存在しない場合はnull
     */
    PurchaseOrder findById(Integer id);

    /**
     * 新規仕入発注情報を登録する
     *
     * @param entity 登録する仕入発注情報
     * @return 登録された仕入発注のID
     */
    Integer insert(PurchaseOrder entity);

    /**
     * 既存の仕入発注情報を更新する
     *
     * @param entity 更新する仕入発注情報
     */
    void update(PurchaseOrder entity);

    /**
     * 指定されたIDの仕入発注情報を削除する
     *
     * @param id 削除対象の仕入発注ID
     */
    void delete(Integer id);

    /**
     * 仕入先情報を含むすべての仕入発注情報を取得する
     *
     * @return 仕入先情報を含む仕入発注情報のリスト
     */
    List<PurchaseOrderWithSupplierDto> findAllWithSupplier();

    /**
     * 指定されたIDの仕入先情報を含む仕入発注情報を取得する
     *
     * @param id 仕入発注ID
     * @return 仕入先情報を含む仕入発注情報、存在しない場合はnull
     */
    PurchaseOrderWithSupplierDto findByIdWithSupplier(Integer id);

    /**
     * 指定されたIDの仕入発注詳細情報を取得する
     *
     * @param id 仕入発注ID
     * @return 仕入発注詳細情報、存在しない場合はnull
     */
    PurchaseOrderDto findOrderDetail(Integer id);
}