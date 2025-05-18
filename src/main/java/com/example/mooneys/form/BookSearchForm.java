package com.example.mooneys.form;

import lombok.*;

import java.math.BigDecimal;

/**
 * 書籍情報検索フォームクラス
 * 書籍情報を検索するための検索条件を保持するフォームクラス
 */
@Getter
@Setter
@NoArgsConstructor
public class BookSearchForm {

    /**
     * ISBN (国際標準図書番号)
     * 書籍を一意に特定するためのコード
     */
    private String isbn;

    /**
     * 書籍タイトル
     * タイトルでの部分一致検索に使用
     */
    private String title;

    /**
     * 著者名
     * 著者名での部分一致検索に使用
     */
    private String author;

    /**
     * 出版社名
     * 出版社名での部分一致検索に使用
     */
    private String publisher;

    /**
     * 販売価格
     * 価格での範囲検索に使用
     */
    private BigDecimal price;

}