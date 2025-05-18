package com.example.mooneys.controller;

import com.example.mooneys.dto.StockWithBookDto;
import com.example.mooneys.entity.Stock;
import com.example.mooneys.form.StockForm;
import com.example.mooneys.form.StockSearchForm;
import com.example.mooneys.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 在庫管理に関する画面制御を行うコントローラー
 */
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    /**
     * 在庫管理サービス
     */
    private final StockService stockService;

    /**
     * 在庫一覧・検索画面を表示する
     *
     * @param form  検索条件
     * @param model ビューに渡すモデル
     * @return 在庫一覧画面
     */
    @GetMapping
    public String list(@ModelAttribute StockSearchForm form, Model model) {
        // 書籍タイトルをキーに在庫情報を検索
        List<StockWithBookDto> stockList = stockService.searchByBookTitle(form.getBookTitle());
        model.addAttribute("stockList", stockList);

        return "stock/list";
    }

    /**
     * 在庫詳細画面を表示する
     *
     * @param id    在庫ID
     * @param model ビューに渡すモデル
     * @return 在庫詳細画面
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        // 指定されたIDの在庫情報を取得
        StockWithBookDto stock = stockService.findStockWithBookById(id);
        model.addAttribute("stock", stock);

        return "stock/detail";
    }

    /**
     * 在庫新規登録画面を表示する
     *
     * @param form 入力フォーム
     * @return 在庫新規登録画面
     */
    @GetMapping("/new")
    public String newForm(@ModelAttribute StockForm form) {
        return "stock/new";
    }

    /**
     * 在庫情報を新規登録する
     *
     * @param form 入力フォーム（バリデーション済み）
     * @return 在庫一覧画面へリダイレクト
     */
    @PostMapping("/new")
    public String create(@ModelAttribute @Validated StockForm form) {
        // 新規在庫情報を登録
        stockService.createStock(form);

        return "redirect:/stock";
    }

    /**
     * 在庫編集画面を表示する
     *
     * @param id   在庫ID
     * @param form 入力フォーム
     * @return 在庫編集画面
     */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, @ModelAttribute StockForm form) {
        // 既存の在庫情報を取得してフォームに設定
        Stock stock = stockService.findById(id);
        form.setIsbn(stock.getIsbn());
        form.setQuantity(stock.getQuantity());

        return "stock/edit";
    }

    /**
     * 在庫情報を更新する
     *
     * @param id   在庫ID
     * @param form 入力フォーム（バリデーション済み）
     * @return 在庫詳細画面へリダイレクト
     */
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute @Validated StockForm form) {
        // 在庫情報を更新
        stockService.updateStock(id, form);

        return "redirect:/stock/" + id;
    }
}