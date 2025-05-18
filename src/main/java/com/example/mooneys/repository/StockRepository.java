package com.example.mooneys.repository;

import com.example.mooneys.dto.StockWithBookDto;
import com.example.mooneys.entity.Stock;
import com.example.mooneys.form.StockSearchForm;

import java.util.List;

/**
 * 在庫情報に関するデータアクセスを行うリポジトリインターフェース
 */
public interface StockRepository {

    /**
     * 在庫情報を検索条件に基づいて検索する
     *
     * @param searchForm 検索条件を含むフォーム
     * @return 検索条件に合致した在庫情報のリスト
     */
    List<Stock> searchStocks(StockSearchForm searchForm);

    /**
     * IDに基づいて在庫情報を取得する
     *
     * @param id 在庫ID
     * @return 該当する在庫情報、存在しない場合はnull
     */
    Stock findById(Integer id);

    /**
     * 新規在庫情報を登録する
     *
     * @param stock 登録する在庫情報
     */
    void insert(Stock stock);

    /**
     * 既存の在庫情報を更新する
     *
     * @param stock 更新する在庫情報
     */
    void update(Stock stock);

    /**
     * 指定されたIDの在庫情報を削除する
     *
     * @param id 削除対象の在庫ID
     */
    void delete(Integer id);

    /**
     * IDに対応する在庫情報と書籍情報を取得する
     *
     * @param id 検索対象の在庫ID
     * @return 在庫情報と書籍情報のDTO、存在しない場合はnull
     */
    StockWithBookDto findStockWithBookById(Integer id);

    /**
     * 書籍タイトルに基づいて在庫情報と書籍情報を検索する
     *
     * @param bookTitle 検索する書籍タイトル
     * @return 書籍タイトルに合致した在庫情報と書籍情報のDTOリスト
     */
    List<StockWithBookDto> searchByBookTitle(String bookTitle);
}