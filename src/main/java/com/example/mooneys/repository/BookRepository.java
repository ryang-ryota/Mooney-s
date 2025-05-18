package com.example.mooneys.repository;

import com.example.mooneys.entity.Book;
import com.example.mooneys.form.BookSearchForm;

import java.util.List;

/**
 * 書籍情報に関するデータアクセスを行うリポジトリインターフェース
 */
public interface BookRepository {

    /**
     * 書籍情報を検索条件に基づいて検索する
     *
     * @param searchForm 検索条件を含むフォーム
     * @return 検索条件に合致した書籍情報のリスト
     */
    List<Book> searchBooks(BookSearchForm searchForm);

    /**
     * ISBNに基づいて書籍情報を取得する
     *
     * @param isbn 国際標準図書番号
     * @return 該当する書籍情報、存在しない場合はnull
     */
    Book findByIsbn(String isbn);

    /**
     * 新規書籍情報を登録する
     *
     * @param book 登録する書籍情報
     */
    void insert(Book book);

    /**
     * 既存の書籍情報を更新する
     *
     * @param book 更新する書籍情報
     */
    void update(Book book);

    /**
     * 指定されたISBNの書籍情報を削除する
     *
     * @param isbn 削除対象の書籍のISBN
     */
    void delete(String isbn);
}