package com.example.mooneys.service;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.entity.PurchaseOrderItem;
import com.example.mooneys.form.PurchaseOrderForm;
import com.example.mooneys.repository.PurchaseOrderItemRepository;
import com.example.mooneys.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 仕入発注サービス実装クラス
 * 仕入発注に関する業務ロジックを実装する
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrder findById(Integer id) {
        return purchaseOrderRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(PurchaseOrderForm form) {
        // 仕入発注基本情報の登録
        PurchaseOrder entity = new PurchaseOrder();
        entity.setOrderDate(form.getOrderDate());
        entity.setStatus(form.getStatus());
        Integer purchaseOrderId = purchaseOrderRepository.insert(entity);

        // 仕入発注明細情報の登録
        for (PurchaseOrderItem item : form.getPurchaseOrderItems()) {
            item.setPurchaseOrderId(purchaseOrderId);
            purchaseOrderItemRepository.insert(item);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Integer id, PurchaseOrderForm form) {
        // 仕入発注基本情報の更新
        PurchaseOrder entity = new PurchaseOrder();
        entity.setId(id);
        entity.setOrderDate(form.getOrderDate());
        entity.setStatus(form.getStatus());
        purchaseOrderRepository.update(entity);

        // 仕入発注明細情報の更新
        for (PurchaseOrderItem item : form.getPurchaseOrderItems()) {
            purchaseOrderItemRepository.update(item);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        // 仕入発注明細情報の削除
        purchaseOrderItemRepository.deleteByPurchaseOrderId(id);

        // 仕入発注基本情報の削除
        purchaseOrderRepository.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderWithSupplierDto> findAllWithSupplier() {
        return purchaseOrderRepository.findAllWithSupplier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrderDto findByIdWithSupplier(Integer id) {
        return purchaseOrderRepository.findOrderDetail(id);
    }

}