package com.example.mooneys.mapper.custom;

import com.example.mooneys.dto.StockWithBookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 在庫情報に関するカスタムSQLマッパーインターフェース
 */
@Mapper
public interface CustomStockMapper {

    /**
     * IDに対応する在庫情報と書籍情報を取得する
     *
     * @param id 在庫ID
     * @return 在庫情報と書籍情報を含むDTO
     */
    StockWithBookDto selectById(@Param("id") Integer id);

    /**
     * 書籍タイトルで部分一致検索を行い、該当する在庫情報と書籍情報を取得する
     *
     * @param bookTitle 検索対象の書籍タイトル
     * @return 在庫情報と書籍情報を含むDTOのリスト
     */
    List<StockWithBookDto> selectByBookTitle(@Param("bookTitle") String bookTitle);
}