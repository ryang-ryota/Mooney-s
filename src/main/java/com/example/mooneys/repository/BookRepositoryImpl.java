package com.example.mooneys.repository;

import com.example.mooneys.entity.Book;
import com.example.mooneys.entity.BookExample;
import com.example.mooneys.form.BookSearchForm;
import com.example.mooneys.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 書籍情報のリポジトリ実装クラス。
 * MyBatisマッパーを使用してデータベース操作を行う。
 */
@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private static final String LIKE_WILDCARD = "%";

    /**
     * 書籍情報のデータベース操作を行うマッパー
     */
    private final BookMapper bookMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> searchBooks(BookSearchForm searchForm) {
        // 検索条件を設定するための Example と Criteria を生成
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();

        // パラメータが入力されている場合、検索条件を追加
        // ISBN完全一致
        Optional.ofNullable(searchForm.getIsbn())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(criteria::andIsbnEqualTo);

        // タイトル名部分一致
        Optional.ofNullable(searchForm.getTitle())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(title -> criteria.andTitleLike(LIKE_WILDCARD + title + LIKE_WILDCARD));

        // 著者名部分一致
        Optional.ofNullable(searchForm.getAuthor())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(author -> criteria.andAuthorLike(LIKE_WILDCARD + author + LIKE_WILDCARD));

        // 出版社名部分一致
        Optional.ofNullable(searchForm.getPublisher())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(publisher -> criteria.andPublisherLike(LIKE_WILDCARD + publisher + LIKE_WILDCARD));

        // 単価完全一致
        Optional.ofNullable(searchForm.getPrice())
                .ifPresent(criteria::andPriceEqualTo);

        // ISBN順でソート
        example.setOrderByClause("isbn ASC");

        // 検索を実行し結果を返却
        return bookMapper.selectByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book findByIsbn(String isbn) {
        return bookMapper.selectByPrimaryKey(isbn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(Book book) {
        bookMapper.insert(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Book book) {
        bookMapper.updateByPrimaryKey(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String isbn) {
        bookMapper.deleteByPrimaryKey(isbn);
    }
}