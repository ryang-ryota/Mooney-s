package com.example.mooneys.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Supplier implements Serializable {
    private Integer id;

    private String name;

    private String address;

    private String contact;

    private static final long serialVersionUID = 1L;
}