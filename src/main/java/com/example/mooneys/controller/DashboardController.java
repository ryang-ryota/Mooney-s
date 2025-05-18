package com.example.mooneys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ダッシュボード画面の表示を制御するコントローラクラス
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    /**
     * ダッシュボード画面を表示する
     *
     * @return ダッシュボード画面のビュー名
     */
    @GetMapping
    public String dashboard(Model model) {
        // 共通レイアウトの業務一覧を非表示にするために属性を設定
        model.addAttribute("isDashboard", true);

        // ダッシュボード画面のテンプレート名を返却
        return "dashboard";
    }

}