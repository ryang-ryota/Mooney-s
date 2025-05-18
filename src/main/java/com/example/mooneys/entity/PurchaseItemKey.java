package com.example.mooneys.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class PurchaseItemKey implements Serializable {
    private Integer purchaseId;

    private String isbn;

    private static final long serialVersionUID = 1L;
}