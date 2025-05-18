package com.example.mooneys.form;

import lombok.*;
import jakarta.validation.constraints.*;

/**
 * 在庫情報フォームクラス
 * 在庫情報の入力および編集に使用する情報を保持するフォームクラス
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockForm {

    /**
     * 在庫ID
     * 在庫を一意に特定するためのID（編集時のみ使用）
     */
    private Long id;

    /**
     * ISBN (国際標準図書番号)
     * 書籍を一意に特定するためのコード
     */
    @NotBlank(message = "ISBNは必須です")
    private String isbn;

    /**
     * 在庫数量
     * 書籍の在庫数を保持する
     */
    @NotNull(message = "在庫数は必須です")
    @Min(value = 0, message = "在庫数は0以上で入力してください")
    private Integer quantity;

}