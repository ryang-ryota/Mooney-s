package com.example.mooneys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Book implements Serializable {
    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}