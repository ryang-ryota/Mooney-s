package com.example.mooneys.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Stock implements Serializable {
    private Integer id;

    private String isbn;

    private Integer quantity;

    private String shelfNo;

    private LocalDate lastReceivedAt;

    private static final long serialVersionUID = 1L;
}