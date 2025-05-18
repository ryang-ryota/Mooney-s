package com.example.mooneys.service;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.form.PurchaseOrderForm;

import java.util.List;

/**
 * 仕入発注サービスインターフェース
 * 仕入発注の検索・登録・更新・削除の業務ロジックを提供する
 */
public interface PurchaseOrderService {

    /**
     * 全ての仕入発注情報を取得する
     *
     * @return 仕入発注情報のリスト
     */
    List<PurchaseOrder> findAll();

    /**
     * 指定されたIDの仕入発注情報を取得する
     *
     * @param id 取得対象の仕入発注ID
     * @return 該当する仕入発注情報
     */
    PurchaseOrder findById(Integer id);

    /**
     * 新規仕入発注情報を登録する
     *
     * @param form 登録する仕入発注情報を含むフォームオブジェクト
     */
    void create(PurchaseOrderForm form);

    /**
     * 既存の仕入発注情報を更新する
     *
     * @param id   更新対象の仕入発注ID
     * @param form 更新内容を含むフォームオブジェクト
     */
    void update(Integer id, PurchaseOrderForm form);

    /**
     * 指定されたIDの仕入発注情報を削除する
     *
     * @param id 削除対象の仕入発注ID
     */
    void delete(Integer id);

    /**
     * 仕入先情報を含む全ての仕入発注情報を取得する
     *
     * @return 仕入先情報を含む仕入発注情報のリスト
     */
    List<PurchaseOrderWithSupplierDto> findAllWithSupplier();

    /**
     * 仕入先情報を含む指定されたIDの仕入発注情報を取得する
     *
     * @param id 取得対象の仕入発注ID
     * @return 仕入先情報を含む仕入発注情報
     */
    PurchaseOrderDto findByIdWithSupplier(Integer id);
}