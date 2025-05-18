package com.example.mooneys.service;

import com.example.mooneys.entity.Book;
import com.example.mooneys.form.BookForm;
import com.example.mooneys.form.BookSearchForm;

import java.util.List;

/**
 * 書籍情報管理サービスインターフェース
 * 書籍の検索・登録・更新・削除の業務ロジックを提供する
 */
public interface BookService {

    /**
     * 指定された検索条件に基づいて書籍情報を検索する
     *
     * @param searchForm 検索条件を含むフォームオブジェクト
     * @return 検索条件に合致する書籍情報のリスト
     */
    List<Book> searchBooks(BookSearchForm searchForm);

    /**
     * 指定されたISBNに対応する書籍情報を取得する
     *
     * @param isbn 検索対象の書籍ISBN
     * @return 該当する書籍情報
     */
    Book findByIsbn(String isbn);

    /**
     * 新規書籍情報を登録する
     *
     * @param form 登録する書籍情報を含むフォームオブジェクト
     */
    void createBook(BookForm form);

    /**
     * 既存の書籍情報を更新する
     *
     * @param isbn 更新対象の書籍ISBN
     * @param form 更新内容を含むフォームオブジェクト
     */
    void updateBook(String isbn, BookForm form);

    /**
     * 指定されたISBNの書籍情報を削除する
     *
     * @param isbn 削除対象の書籍ISBN
     */
    void deleteBook(String isbn);
}