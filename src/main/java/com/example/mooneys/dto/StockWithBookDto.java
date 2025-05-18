package com.example.mooneys.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 在庫情報と書籍情報を保持するDTOクラス
 */
@Getter
@Setter
public class StockWithBookDto {

    /**
     * 在庫ID
     */
    private Long id;

    /**
     * ISBN (国際標準図書番号)
     * 書籍を一意に特定するためのコード
     */
    private String isbn;

    /**
     * 書籍タイトル
     */
    private String bookTitle;

    /**
     * 在庫数量
     */
    private Integer quantity;

}