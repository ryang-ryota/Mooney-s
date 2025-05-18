package com.example.mooneys.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Purchase implements Serializable {
    private Integer id;

    private Integer purchaseOrderId;

    private LocalDate receiveDate;

    private String status;

    private static final long serialVersionUID = 1L;
}