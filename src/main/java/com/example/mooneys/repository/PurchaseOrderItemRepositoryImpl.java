package com.example.mooneys.repository;

import com.example.mooneys.entity.PurchaseOrderItem;
import com.example.mooneys.entity.PurchaseOrderItemExample;
import com.example.mooneys.mapper.PurchaseOrderItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仕入発注明細情報のデータアクセスを行うリポジトリの実装クラス
 */
@Repository
@RequiredArgsConstructor
public class PurchaseOrderItemRepositoryImpl implements PurchaseOrderItemRepository {

    private final PurchaseOrderItemMapper purchaseOrderItemMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderItem> findAll() {
        // 検索条件なしで全件取得
        PurchaseOrderItemExample example = new PurchaseOrderItemExample();
        return purchaseOrderItemMapper.selectByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderItem> findByPurchaseOrderId(Integer purchaseOrderId) {
        // 指定された仕入発注IDに紐づく明細を検索
        PurchaseOrderItemExample example = new PurchaseOrderItemExample();
        example.createCriteria().andPurchaseOrderIdEqualTo(purchaseOrderId);
        return purchaseOrderItemMapper.selectByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(PurchaseOrderItem entity) {
        // 新規仕入発注明細情報を登録
        purchaseOrderItemMapper.insert(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(PurchaseOrderItem entity) {
        // 既存の仕入発注明細情報を更新
        purchaseOrderItemMapper.updateByPrimaryKey(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByPurchaseOrderId(Integer purchaseOrderId) {
        // 指定された仕入発注IDに紐づく明細を削除
        PurchaseOrderItemExample example = new PurchaseOrderItemExample();
        example.createCriteria().andPurchaseOrderIdEqualTo(purchaseOrderId);
        purchaseOrderItemMapper.deleteByExample(example);
    }
}