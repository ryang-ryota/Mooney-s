package com.example.mooneys.service;

import com.example.mooneys.entity.Book;
import com.example.mooneys.form.BookForm;
import com.example.mooneys.form.BookSearchForm;
import com.example.mooneys.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 書籍情報管理サービスの実装クラス
 * 書籍の検索・登録・更新・削除などの業務ロジックを提供する
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> searchBooks(BookSearchForm searchForm) {
        // 検索条件に基づいて書籍情報を検索
        return bookRepository.searchBooks(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book findByIsbn(String isbn) {
        // ISBNに紐づく書籍情報を取得
        return bookRepository.findByIsbn(isbn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createBook(BookForm form) {
        // フォームの内容を元に書籍エンティティを生成
        Book book = new Book();
        book.setIsbn(form.getIsbn());
        book.setTitle(form.getTitle());
        book.setAuthor(form.getAuthor());
        book.setPublisher(form.getPublisher());
        book.setPrice(form.getPrice());

        // 書籍情報を登録
        bookRepository.insert(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateBook(String isbn, BookForm form) {
        // フォームの内容を元に書籍エンティティを生成
        Book book = new Book();
        book.setIsbn(isbn); // ISBNは変更不可
        book.setTitle(form.getTitle());
        book.setAuthor(form.getAuthor());
        book.setPublisher(form.getPublisher());
        book.setPrice(form.getPrice());

        // 書籍情報を更新
        bookRepository.update(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBook(String isbn) {
        // 指定されたISBNの書籍情報を削除
        bookRepository.delete(isbn);
    }
}