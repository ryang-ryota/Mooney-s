package com.example.mooneys.form;

import lombok.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * 書籍情報登録フォームクラス
 * 書籍の基本情報を入力・編集するためのフォームクラス
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

    /**
     * ISBN (国際標準図書番号)
     * 書籍を一意に特定するためのコード
     */
    @NotBlank(message = "ISBNは必須です")
    private String isbn;

    /**
     * 書籍タイトル
     */
    @NotBlank(message = "書名は必須です")
    private String title;

    /**
     * 著者名
     */
    @NotBlank(message = "著者名は必須です")
    private String author;

    /**
     * 出版社名
     */
    @NotBlank(message = "出版社名は必須です")
    private String publisher;

    /**
     * 販売価格
     * 税抜き価格を設定
     */
    @NotNull(message = "価格は必須です")
    @DecimalMin(value = "0", inclusive = true, message = "価格は0以上で入力してください")
    private BigDecimal price;

}