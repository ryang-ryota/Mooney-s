package com.example.mooneys.repository;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.mapper.PurchaseOrderMapper;
import com.example.mooneys.mapper.custom.CustomPurchaseOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仕入発注リポジトリの実装クラス
 */
@Repository
@RequiredArgsConstructor
public class PurchaseOrderRepositoryImpl implements PurchaseOrderRepository {

    /**
     * 仕入発注マッパー
     */
    private final PurchaseOrderMapper purchaseOrderMapper;

    /**
     * カスタム仕入発注マッパー
     */
    private final CustomPurchaseOrderMapper customPurchaseOrderMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrder> findAll() {
        // パラメータにnullを指定して全件検索
        return purchaseOrderMapper.selectByExample(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrder findById(Integer id) {
        // 主キーによる単一レコードの検索
        return purchaseOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer insert(PurchaseOrder entity) {
        // NULL項目を除外して新規登録
        return purchaseOrderMapper.insertSelective(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(PurchaseOrder entity) {
        // 主キーによる更新
        purchaseOrderMapper.updateByPrimaryKey(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        // 主キーによる削除
        purchaseOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderWithSupplierDto> findAllWithSupplier() {
        // 仕入先情報を含む全件検索
        return customPurchaseOrderMapper.selectAllWithSupplier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrderWithSupplierDto findByIdWithSupplier(Integer id) {
        // 仕入先情報を含む単一レコードの検索
        return customPurchaseOrderMapper.selectByIdWithSupplier(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrderDto findOrderDetail(Integer id) {
        // 仕入発注明細を含む発注情報の検索
        return customPurchaseOrderMapper.findOrderDetail(id);
    }
}