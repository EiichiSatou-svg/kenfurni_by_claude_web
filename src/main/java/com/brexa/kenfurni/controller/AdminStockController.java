package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.service.AdminStockService;

/**
 * 管理側商品在庫一覧コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/stock")
public class AdminStockController {

    private final AdminStockService adminStockService;

    public AdminStockController(AdminStockService adminStockService) {
        this.adminStockService = adminStockService;
    }

    /**
     * 商品在庫一覧画面表示
     *
     * @param model モデル
     * @return 商品在庫一覧画面テンプレート名
     */
    @GetMapping
    public String showStockList(Model model) {
        model.addAttribute("stockList", adminStockService.findAll());
        return "admin/stock_list";
    }
}