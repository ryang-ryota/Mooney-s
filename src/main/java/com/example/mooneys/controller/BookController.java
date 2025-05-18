package com.example.mooneys.controller;

import com.example.mooneys.entity.Book;
import com.example.mooneys.form.BookForm;
import com.example.mooneys.form.BookSearchForm;
import com.example.mooneys.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * 書籍情報に関する画面処理を行うコントローラクラス
 */
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    /**
     * 書籍サービス
     */
    private final BookService bookService;

    /**
     * メッセージソース
     */
    private final MessageSource messageSource;

    /**
     * 書籍一覧・検索画面を表示する
     *
     * @param bookSearchForm 検索条件フォーム
     * @param model          モデル
     * @param locale         ロケール情報
     * @return 書籍一覧画面
     */
    @GetMapping
    public String list(@ModelAttribute BookSearchForm bookSearchForm, Model model, Locale locale) {
        // 検索条件に基づいて書籍情報を取得
        List<Book> books = bookService.searchBooks(bookSearchForm);

        // 検索結果が0件の場合はメッセージを設定
        if (CollectionUtils.isEmpty(books)) {
            String message = messageSource.getMessage("error.notfound", null, locale);
            model.addAttribute("message", message);
        }

        model.addAttribute("books", books);
        return "book/list";
    }

    /**
     * 書籍詳細画面を表示する
     *
     * @param isbn  ISBN
     * @param model モデル
     * @return 書籍詳細画面
     */
    @GetMapping("/{isbn}")
    public String detail(@PathVariable String isbn, Model model) {
        // ISBNに該当する書籍情報を取得
        Book book = bookService.findByIsbn(isbn);

        if (book == null) {
            // TODO: エラー実装
            //throw new ResourceNotFoundException("書籍が見つかりません: " + isbn);
        }

        model.addAttribute("book", book);
        return "book/detail";
    }

    /**
     * 書籍新規登録画面を表示する
     *
     * @param bookForm 書籍情報フォーム
     * @return 書籍新規登録画面
     */
    @GetMapping("/new")
    public String showCreateForm(@ModelAttribute BookForm bookForm) {
        return "book/new";
    }

    /**
     * 書籍情報を新規登録する
     *
     * @param bookForm      書籍情報フォーム
     * @param bindingResult バリデーション結果
     * @return 登録成功時：書籍一覧画面、失敗時：書籍新規登録画面
     */
    @PostMapping("/new")
    public String create(@ModelAttribute @Validated BookForm bookForm, BindingResult bindingResult) {
        // 入力チェックエラーがある場合は登録画面に戻る
        if (bindingResult.hasErrors()) {
            return "book/new";
        }

        // 書籍情報を登録
        bookService.createBook(bookForm);
        return "redirect:/book";
    }

    /**
     * 書籍編集画面を表示する
     *
     * @param isbn     ISBN
     * @param bookForm 書籍情報フォーム
     * @param model    モデル
     * @return 書籍編集画面
     */
    @GetMapping("/edit/{isbn}")
    public String showEditForm(@PathVariable String isbn, @ModelAttribute BookForm bookForm, Model model) {
        // 編集対象の書籍情報を取得
        Book book = bookService.findByIsbn(isbn);

        if (book == null) {
            // TODO: エラー実装
            //throw new ResourceNotFoundException("書籍が見つかりません: " + isbn);
        }

        bookForm.setIsbn(book.getIsbn());
        bookForm.setTitle(book.getTitle());
        bookForm.setAuthor(book.getAuthor());
        bookForm.setPublisher(book.getPublisher());
        bookForm.setPrice(book.getPrice());
        return "book/edit";
    }

    /**
     * 書籍情報を更新する
     *
     * @param isbn          ISBN
     * @param bookForm      書籍情報フォーム
     * @param bindingResult バリデーション結果
     * @return 更新成功時：書籍詳細画面、失敗時：書籍編集画面
     */
    @PostMapping("/edit/{isbn}")
    public String edit(@PathVariable String isbn, @ModelAttribute @Validated BookForm bookForm, BindingResult bindingResult) {
        // 入力チェックエラーがある場合は編集画面に戻る
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }

        // 書籍情報を更新
        bookService.updateBook(isbn, bookForm);
        return "redirect:/book/" + isbn;
    }

    /**
     * 書籍情報を削除する
     *
     * @param isbn ISBN
     * @return 書籍一覧画面
     */
    @PostMapping("/delete/{isbn}")
    public String delete(@PathVariable String isbn) {
        // 書籍情報を削除
        bookService.deleteBook(isbn);
        return "redirect:/book";
    }
}