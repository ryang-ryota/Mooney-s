package com.example.mooneys.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class PurchaseOrderItemKey implements Serializable {
    private Integer purchaseOrderId;

    private String isbn;

    private static final long serialVersionUID = 1L;
}