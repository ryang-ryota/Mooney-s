package com.example.mooneys.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class PurchaseItem extends PurchaseItemKey implements Serializable {
    private Integer quantity;

    private static final long serialVersionUID = 1L;
}