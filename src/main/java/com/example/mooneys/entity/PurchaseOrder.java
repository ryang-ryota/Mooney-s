package com.example.mooneys.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PurchaseOrder implements Serializable {
    private Integer id;

    private Integer supplierId;

    private LocalDate orderDate;

    private String status;

    private static final long serialVersionUID = 1L;
}