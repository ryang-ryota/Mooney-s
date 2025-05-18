package com.example.mooneys.form;

import lombok.*;

/**
 * 在庫検索フォームクラス
 * 在庫情報を検索するための検索条件を保持するフォームクラス
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockSearchForm {

    /**
     * ISBN (国際標準図書番号)
     * 書籍を一意に特定するためのコード
     */
    private String isbn;

    /**
     * 書籍タイトル
     * 書籍名での部分一致検索に使用
     * 書籍テーブルとのJOINで使用
     */
    private String bookTitle;

}