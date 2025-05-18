package com.example.mooneys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PurchaseOrderItem extends PurchaseOrderItemKey implements Serializable {
    private Integer quantity;

    private BigDecimal unitPrice;

    private static final long serialVersionUID = 1L;
}