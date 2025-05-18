package com.example.mooneys.service;

import com.example.mooneys.dto.StockWithBookDto;
import com.example.mooneys.entity.Stock;
import com.example.mooneys.form.StockForm;
import com.example.mooneys.form.StockSearchForm;

import java.util.List;

/**
 * 在庫情報管理サービスインターフェース
 * 在庫の検索・登録・更新・削除の業務ロジックを提供する
 */
public interface StockService {

    /**
     * 指定された検索条件に基づいて在庫情報を検索する
     *
     * @param searchForm 検索条件を含むフォームオブジェクト
     * @return 検索条件に合致する在庫情報のリスト
     */
    List<Stock> searchStocks(StockSearchForm searchForm);

    /**
     * 指定されたIDに対応する在庫情報を取得する
     *
     * @param id 検索対象の在庫ID
     * @return 該当する在庫情報
     */
    Stock findById(Integer id);

    /**
     * 新規在庫情報を登録する
     *
     * @param form 登録する在庫情報を含むフォームオブジェクト
     */
    void createStock(StockForm form);

    /**
     * 既存の在庫情報を更新する
     *
     * @param id   更新対象の在庫ID
     * @param form 更新内容を含むフォームオブジェクト
     */
    void updateStock(Long id, StockForm form);

    /**
     * 指定されたIDの在庫情報を削除する
     *
     * @param id 削除対象の在庫ID
     */
    void deleteStock(Integer id);

    /**
     * IDに対応する在庫情報と書籍情報を取得する
     *
     * @param id 検索対象の在庫ID
     * @return 在庫情報と書籍情報のDTO
     */
    StockWithBookDto findStockWithBookById(Integer id);

    /**
     * 書籍タイトルに基づいて在庫情報を検索する
     * 書籍情報と結合した結果を返す
     *
     * @param bookTitle 検索対象の書籍タイトル
     * @return 検索条件に合致する在庫情報と書籍情報のDTOリスト
     */
    List<StockWithBookDto> searchByBookTitle(String bookTitle);
}