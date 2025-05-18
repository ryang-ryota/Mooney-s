package com.example.mooneys.controller;

import com.example.mooneys.dto.PurchaseOrderDto;
import com.example.mooneys.dto.PurchaseOrderWithSupplierDto;
import com.example.mooneys.entity.PurchaseOrder;
import com.example.mooneys.form.PurchaseOrderForm;
import com.example.mooneys.service.PurchaseOrderService;
import com.example.mooneys.service.PurchaseOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 仕入発注管理のコントローラークラス
 */
@Controller
@RequestMapping("/purchase-order")
@RequiredArgsConstructor
public class PurchaseOrderController {

    /**
     * 発注サービス
     */
    private final PurchaseOrderService purchaseOrderService;

    /**
     * 発注一覧画面を表示
     *
     * @param model モデル
     * @return 発注一覧画面
     */
    @GetMapping
    public String list(Model model) {
        // 発注一覧を取得
        List<PurchaseOrderWithSupplierDto> purchaseOrderList = purchaseOrderService.findAllWithSupplier();

        // モデルに発注一覧を設定
        model.addAttribute("purchaseOrderList", purchaseOrderList);

        return "purchase-order/list";
    }

    /**
     * 新規登録画面を表示
     *
     * @param form 発注フォーム
     * @return 新規登録画面
     */
    @GetMapping("/new")
    public String viewCreate(@ModelAttribute PurchaseOrderForm form) {
        return "purchase-order/new";
    }

    /**
     * 新規登録を実行
     *
     * @param form 入力された発注情報
     * @return 発注一覧画面へリダイレクト
     */
    @PostMapping("/new")
    public String create(@ModelAttribute @Validated PurchaseOrderForm form) {
        // 発注情報を登録
        purchaseOrderService.create(form);
        return "redirect:/purchase-order";
    }

    /**
     * 編集画面を表示
     *
     * @param id   発注ID
     * @param form 発注フォーム
     * @return 編集画面
     */
    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable Integer id, @ModelAttribute PurchaseOrderForm form) {
        // 発注情報を取得
        PurchaseOrderDto purchaseOrder = purchaseOrderService.findByIdWithSupplier(id);

        // フォームに発注情報を設定
        form.setId(purchaseOrder.getId());
        form.setSupplierName(purchaseOrder.getSupplierName());
        form.setOrderDate(purchaseOrder.getOrderDate());
        form.setStatus(purchaseOrder.getStatus());
        form.setPurchaseOrderItems(purchaseOrder.getPurchaseOrderItems());

        return "purchase-order/edit";
    }

    /**
     * 編集を実行
     *
     * @param id   発注ID
     * @param form 編集された発注情報
     * @return 発注一覧画面へリダイレクト
     */
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @ModelAttribute @Validated PurchaseOrderForm form) {
        // 発注情報を更新
        purchaseOrderService.update(id, form);
        return "redirect:/purchase-order";
    }

    /**
     * 削除を実行
     *
     * @param id 削除する発注ID
     * @return 発注一覧画面へリダイレクト
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // 発注情報を削除
        purchaseOrderService.delete(id);
        return "redirect:/purchase-order";
    }
}